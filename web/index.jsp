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
  </style>


  <script>
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
          if (data != "") {
              $('#fieldDiv').html('');
              $.each(data.field, function (key, val) {
                  $('#fieldDiv').append('<br>');
                  $.each(val, function (keyLine, valLine) {
                      $.each(valLine, function (keyCell, valCell) {
                          var $value = valCell.open ? valCell.value : valCell.rightValue;
                          $('#fieldDiv').append('<button class="button" oncontextmenu="func(' + valCell.lineId + ',' + valCell.cellId + '); return false;" onclick="move(' + valCell.lineId + ',' + valCell.cellId + ')">' + $value + '</button>');
                      });
                  });
              });
          }
          console.log(${sessionScope.get("checkWin")});
          $('#checkWin').append(${sessionScope.get("checkWin")});
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

  <h2 id="checkWin" align="center"></h2>

</body>
</html>
