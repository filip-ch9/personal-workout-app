package com.codeacademyfinalproject.personalworkoutapp.view.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.codeacademyfinalproject.personalworkoutapp.model.TrainingDay;
import com.codeacademyfinalproject.personalworkoutapp.service.TrainingDayService;
import com.codeacademyfinalproject.personalworkoutapp.service.WorkoutProgramService;

@Controller
public class WorkoutProgramController {

	@Value("${uploadDir}")
	private String uploadFolder;

	@Autowired
	private TrainingDayService trainingDayService;

	@Autowired
	private WorkoutProgramService workoutProgramService;

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/training")
	public String showCreateWorkoutPage() {
		return "training";
	}

	@PostMapping("/training/saveTraining")
	public @ResponseBody ResponseEntity<?> createTraining(@RequestParam("name") String nameOfExercise, 
				@RequestParam("duration") String duration, @RequestParam("date") Date dayOfTraining, @RequestParam("sets") int sets, 
				@RequestParam("reps") int reps, @RequestParam("pause") long pause, Model model, 
				HttpServletRequest request, final @RequestParam("image") MultipartFile file) {
		try {
				String uploadDirectory = request.getServletContext().getRealPath(uploadFolder);
				log.info("uploadDirectory::" + uploadDirectory);
				String fileName = file.getOriginalFilename();
				String filePath = Paths.get(uploadDirectory, fileName).toString();
				log.info("FileName: " + file.getOriginalFilename());
				if (fileName == null || fileName.contains("..")) {
					model.addAttribute("invalid", "Sorry! Filename contains invalid path sequence \" + fileName");
					return new ResponseEntity<>("Sorry! Filename contains invalid path sequence" + fileName, HttpStatus.BAD_REQUEST);
			}
 			String[] namesOfExercise = nameOfExercise.split(",");
			String[] durations = duration.split(",");
			log.info("name: " + namesOfExercise[0] + " " + filePath);
			log.info("duration: " + durations[0]);
			log.info("date" + dayOfTraining);
			log.info("sets: " + sets);
			log.info("reps: " + reps);
			log.info("pause: " + pause);
			try {
				File dir = new File(uploadDirectory);
				if (!dir.exists()) {
					log.info("Folder Created");
					dir.mkdirs();
				}
				// Save the file locally
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
				stream.write(file.getBytes());
				stream.close();
			} catch (Exception e) {
				log.info("in catch");
				e.printStackTrace();
			}
			byte[] imageData = file.getBytes();
			TrainingDay training = new TrainingDay();
			training.setNameOfExercise(namesOfExercise[0]);
			training.setImage(imageData);
			training.setDuration(durations[0]);
			training.setDayOfTraining(dayOfTraining);
			training.setSets(sets);
			training.setReps(reps);
			training.setPause(pause);
			trainingDayService.saveTrainingDay(training);
			log.info("HttpStatus===" + new ResponseEntity<>(HttpStatus.OK));
			return new ResponseEntity<>("Training Saved With File - " + fileName, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception: " + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/training/display/{id}")
	@ResponseBody
	void showImage(@PathVariable("id") long id, HttpServletResponse  response, Optional<TrainingDay> trainingDay) 
					throws ServletException, IOException {
		log.info("Id: " + id);
		trainingDay = trainingDayService.getTrainingDayById(id);
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.getOutputStream().write(trainingDay.get().getImage());
		response.getOutputStream().close();
	}
	
	@GetMapping("/training/trainingdetails") 
	String showTrainingDayDetails(@RequestParam("id") long id, Optional<TrainingDay> trainingDay, Model model) {
		try {
				log.info("Id :: " + id);
				if (id != 0) {
					trainingDay = trainingDayService.getTrainingDayById(id);
					
					log.info("trainings :: " + trainingDay);
					if (trainingDay.isPresent()) {
						model.addAttribute("id", trainingDay.get().getId());
						model.addAttribute("nameOfExercise", trainingDay.get().getNameOfExercise());
						model.addAttribute("duration", trainingDay.get().getDuration());
						model.addAttribute("sets", trainingDay.get().getSets());
						model.addAttribute("reps", trainingDay.get().getReps());
						model.addAttribute("pause", trainingDay.get().getPause());
						return "trainingdetails";
					}
					return "redirect:/coach-profile";
				}
			return "redirect:/coach-profile";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/coach-profile";
		}
	}
	
	@GetMapping("/training/show")
	String show(Model map) {
		List<TrainingDay> trainings = trainingDayService.getAllTrainingDays();
		map.addAttribute("trainings", trainings);
		return "trainings";
	}
	
}
