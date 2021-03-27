package com.codeacademyfinalproject.personalworkoutapp.view.controller;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.codeacademyfinalproject.personalworkoutapp.model.TrainingDay;
import com.codeacademyfinalproject.personalworkoutapp.service.TrainingDayService;
import com.codeacademyfinalproject.personalworkoutapp.service.WorkoutProgramService;

@Controller
@RequestMapping("/myImage")
public class ImageController {

	@Resource(name = "trainingDayService")
	private TrainingDayService trainingDayService;

	@Resource(name = "workoutProgramService")
	private WorkoutProgramService workoutProgramService;

	@GetMapping("/imageDisplay")
	public void showImage(@RequestParam("id") Long trainingId, HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {

		TrainingDay training = trainingDayService.getTrainingDayById(trainingId);
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.getOutputStream().write(training.getImage());

		response.getOutputStream().close();
	}
	
	 @PostMapping
	    Long uploadImage(@RequestParam MultipartFile multipartImage) throws Exception {
	        TrainingDay training = new TrainingDay();
	        training.setImage(multipartImage.getBytes());

	        return trainingDayService.updateTrainingDay(training)
	            .getId();
	    }
	
}