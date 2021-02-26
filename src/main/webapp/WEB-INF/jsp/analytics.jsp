<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="common/navbar.jspf"%>
<%@ include file="common/header.jspf"%>
    <meta charset="utf-8" />
    <title>Analytics</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css" />

    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>

<!-- Bootstrap Charts - START -->
<div class="container">
    <div class="row">
        <div class="col-md-6">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3>User Performance</h3>
                </div>
                <div class="panel-body">
                    <div id="chart1"></div>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3>User Test</h3>
                </div>
                <div id="chart2" class="panel-body">
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3>User Upcoming Weaks</h3>
                </div>
                <div class="panel-body">
                    <div id="chart3"></div>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3>User Reports</h3>
                </div>
                <div id="chart4" class="panel-body">
                </div>
            </div>
        </div>
    </div>   
</div>

<!-- you need to include the shieldui css and js assets in order for the charts to work -->
<link rel="stylesheet" type="text/css" href="http://www.shieldui.com/shared/components/latest/css/light-bootstrap/all.min.css" />
<script type="text/javascript" src="http://www.shieldui.com/shared/components/latest/js/shieldui-all.min.js"></script>

<script type="text/javascript">
    jQuery(function ($) {
        var data1 = [12, 3, 4, 2, 12, 3, 4, 17, 22, 34, 54, 67];
        var data2 = [3, 9, 12, 14, 22, 32, 45, 12, 67, 45, 55, 7];
        var data3 = [23, 19, 11, 134, 242, 352, 435, 22, 637, 445, 555, 57];
        var data4 = [13, 19, 112, 114, 212, 332, 435, 132, 67, 45, 55, 7];
            
        $("#chart1").shieldChart({
            exportOptions: {
                image: false,
                print: false
            },
            axisY: {
                title: {
                    text: "My Tests"
                }
            },
            dataSeries: [{
                seriesType: "line",
                data: data1
            }]
        });

        $("#chart2").shieldChart({
            exportOptions: {
                image: false,
                print: false
            },
            axisY: {
                title: {
                    text: "Break-Down for selected quarter"
                }
            },
            dataSeries: [{
                seriesType: "polarbar",
                data: data2
            }]
        });

        $("#chart3").shieldChart({
            exportOptions: {
                image: false,
                print: false
            },
            axisY: {
                title: {
                    text: "Break-Down for selected quarter"
                }
            },
            dataSeries: [{
                seriesType: "area",
                data: data3
            }]
        });

        $("#chart4").shieldChart({
            exportOptions: {
                image: false,
                print: false
            },
            axisY: {
                title: {
                    text: "Break-Down for selected quarter"
                }
            },
            dataSeries: [{
                seriesType: "stepline",
                data: data4
            }]
        });
    });
</script>
<!-- Bootstrap Charts - END -->


<%@ include file="common/footer.jspf"%>