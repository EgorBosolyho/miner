<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Miner</title>
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script>

  <style type="text/css">
    .button {
      margin: 0.5px;
      width: 30px;
      height: 30px;
    }

    /**{*/
      /*padding: 0;*/
      /*margin:0;*/
    /*}*/
  </style>


  <script>

      $(document).ready(function () {
          $('button').on('mousedown', function (event) {
              var keycode = ( event.keyCode ? event.keyCode : event.which );
              if (keycode === 3) {
                  //your right click code goes here
                  alert("dada");
              }
          });
      });




      function move(lineId,cellId) {
          $.ajax({
              type: 'GET',
              url: '/field/move',
              data: {lineId: lineId, cellId: cellId},
              success: function (data){
                  paintField(data);
              }
          });
      }

      function reset() {
          $.ajax({
              type: 'GET',
              url: '/field/get',
              success: function (data){
                  paintField(data);
              }
          });
      }

      function paintField(data){
          $('#fieldDiv').html('');
          $.each(data.field, function (key, val) {
              $('#fieldDiv').append('<br>');
              $.each(val, function (keyLine, valLine) {
                  $.each(valLine, function (keyCell, valCell) {
                      var $value = valCell.open ? valCell.value : valCell.rightValue;
                      $('#fieldDiv').append('<button class="button" oncontextmenu="func('+valCell.lineId+','+valCell.cellId+'); return false;" onclick="move('+valCell.lineId+','+valCell.cellId+')">'+$value+'</button>');
                  });
              });
          });
      }

      function func(lineId,cellId){
          $.ajax({
              type: 'GET',
              url: '/field/right',
              data: {lineId: lineId, cellId: cellId},
              success: function (data){
                  paintField(data);
              }
          });
      }
  </script>
</head>
<body>


  <input type="button" value="get" onclick="reset()"/>
  <div id="fieldDiv">
  </div>

</body>
</html>
