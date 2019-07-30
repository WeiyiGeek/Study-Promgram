<?php
  $NULLValue = NULL;
  $emptyValue;
  $integ = 1024;
  unset($integ);
  var_dump($NULLValue);
  echo "<br>";
  var_dump($emptyValue);
  echo "<br>";
  var_dump($integ);
?>
