/**
 * 
 */
 dojo.require('dijit.form.Button');
dojo.require('dijit.form.TextBox');
dojo.require('dijit.form.CheckBox');
dojo.require('dojo.io.script');
dojo.require('dojox.grid.DataGrid');
dojo.require('dojo.data.ItemFileReadStore');


dojo.create("h1",{innerHTML :"  Enter the ID of Employee"},dojo.query("div")[0],"first");
dojo.create("input",{type : "text",id :"inp1"},dojo.query("h1")[0],"after");
dojo.require("dijit.form.Button");
var btn1= new dijit.form.Button({label :"Check",id :"btn1"});
dojo.place(btn1.domNode,dojo.byId("inp1"),"after");


dojo.attr(dojo.byId("btn1"),{onclick:function () {
	var empID=dojo.attr(dojo.byId("inp1"),"value");
console.log(	fetch(`http://localhost:8091/api/v1/employees/${empID}`)
.then(res =>res.json())
.then(data =>alert(`             The ID is ${data.id}
                     First Nmae is ${data.fname}
                     Last Name is ${data.lname}`))
)
}});

dojo.attr(dojo.byId("btn"),{onclick:function () {
	var fname1=dojo.attr(dojo.byId("fname"),"value"),lname1=dojo.attr(dojo.byId("lname"),"value")
	depID1=dojo.attr(dojo.byId("depID"),"value");
	dojo.attr(dojo.byId("fname"),"value","");
	dojo.attr(dojo.byId("lname"),"value","");
	dojo.attr(dojo.byId("depID"),"value","");
console.log(	fetch(`http://localhost:8091/api/v1/employees`,{
	method :'POST',
	headers :{'Content-Type' : 'application/json'},
	body : JSON.stringify({
		fname :fname1,lname :lname1,dep_id :depID1
	})
	})
.then(res =>{return res.json()})
.then(function(){
	aler("ADD SUCCESS");
	alert("sssss");
}


) 
)
}});

var btn2=new dijit.form.Button({label :"All Employees",id :"btn2",onClick :c});
dojo.place(btn2.domNode,dojo.query("td")[7]);


//dojo.attr(dojo.byId("btn2"),{"onClick" : "c"});

async function c(){
	console.log("c");
	const res=await fetch(`http://localhost:8091/api/v1/employees`);
	const data = await res.json();
  pData(data);

}
 function pData(data){
	
		var e=document.querySelector("#table2"),cont=1;
		
		e.innerHTML=`<table><thead><th>#</th><th>First name</th><th>Last Name</th><th>Depatrment ID</th></thead>
		<tbody>${data.map(m=>`<tr><td>${cont++}</td><td>${m.fname}</td><td>${m.lname}</td><td>${m.dep_id}</td></tr>`)}</tbody></table>`;
}

