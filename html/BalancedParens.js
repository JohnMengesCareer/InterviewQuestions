"use strict";
function run()
{
	d3.json("BalancedParens.json", draw);
}

function draw(data)
{
	var dataTable=
		d3.select("body")
		.append("table");
	
	dataTable.append("tr");
	
	var chars=data.string.split("");
		
	dataTable
		.select("tr")
		.selectAll("th")
		.data(chars)
		.enter()
		.append("th")
		.text(function index(d,i) {return i});
	
	
}

window.onload=run
