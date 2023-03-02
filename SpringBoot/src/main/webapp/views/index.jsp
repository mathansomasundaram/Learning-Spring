<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>First Spring Boot Application</title>
</head>
<body>
	
	<form action="add">
		<div class="ui-field-contain">
			<label for="text-1">Enter 1st Number</label>
			<input name="number1" id="text-1" data-clear-btn="true" value="" placeholder="Enter 1st Input" type="text"/>
		</div>
		<br>
		<div class="ui-field-contain">
			<label for="text-1">Enter 2nd Number</label>
			<input name="number2" id="text-1" data-clear-btn="true" value="" placeholder="Enter 1st Input" type="text"/>
		</div>
		<br>
		<div class="ui-input-btn ui-btn ui-corner-all">
			Add Number
			<input data-enhanced="true" type="submit" value="Add Number" id="button-1"/>
		</div>
	</form>
</body>
</html>