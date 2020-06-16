function ValoresController(opcion) {
	$("#msg").hide();
	$("#msg").removeClass("alert-success").addClass("alert-danger");
	//var token = $("meta[name='_csrf']").attr("content");
	
	switch(opcion){
	case "list":
		$.ajax({
			type : "post",
		  //  headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
			url : "/valores/list",
			success : function(res) {
				$('#valoresTable').bootstrapTable('load', res);
				
				$('#valoresTable tbody').on('click', 'tr', function () {
					$("#origen").val($(this).find("td:eq(0)").text());
					$("#destino").val($(this).find("td:eq(1)").text());
					$("#costo").val($(this).find("td:eq(2)").text());
					$("#cant_pasajeros").val($(this).find("td:eq(3)").text());
					$("#myModal .close").click();
				});
				
				
				$("#myModal").modal({show:true});
			},
			error : function() {
				$("#msg").show();
				$("#msg").html("Error en busqueda de empleados.")
			}
		});       			
		break;
	case "get":
		$.ajax({
			type : "post",
		   // headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
			url : "/valores/get",
			data : "origen="+$("#origen").val(),
			success : function(res) {
				if (res == null || res == "") {
					$("#msg").show();
					$("#msg").html("No se encontraron registros.");
				} else {
					
					$("#origen").val(res.origen);
					$("#destino").val(res.destino);
					$("#costo").val(res.costo);
					$("#cant_pasajeros").val(res.cant_pasajeros);
				}
			},
			error : function() {
				$("#msg").show();
				$("#msg").html("Error en busqueda.");
			}
		});       			
		break;
	case "insert":
		$("#employee_id").val(0),
		$("#first_name").val(""),
		$("#last_name").val(""),
		$("#email").val(""),
		$("#phone_number").val(""),
		$("#hire_date").val(new Date()),
		$("#job_id").val(""),
		$("#salary").val(0),
		$("#commission_pct").val(0),
		$("#manager_id").val(0),
		$("#departent_id").val(0)	
	    break;
	case "update":
		var json = 
			{
				'employee_id': $("#employee_id").val(),
				'first_name': $("#first_name").val(),
				'last_name': $("#last_name").val(),
				'email': $("#email").val(),
				'phone_number': $("#phone_number").val(),
				'hire_date': $("#hire_date").val(),
				'job_id': $("#job_id").val(),
				'salary': ( $("#salary").val() ? $("#salary").val() : "0"),
				'commission_pct': ( $("#commission_pct").val() ? $("#commission_pct").val() : "0"),
				'manager_id': $("#manager_id").val(),
				'deparment_id': $("#departent_id").val()
			};

		var postData = JSON.stringify(json);

		$.ajax({
			type : "post",
		  //  headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
			url : "/employees/update",
			data : postData,
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			success : function(res) {
				if (res == 1) {
					$("#msg").removeClass("alert-danger").addClass("alert-success");
					$("#msg").show();
					$("#msg").html("Registro modificado correctamente.");
				} else {
					$("#msg").show();
					$("#msg").html("No se pudo modificar el registro.");
				}
			},
			error : function() {
				$("#msg").show();
				$("#msg").html("No se pudo modificar el registro.");
			}
		});       	
    break;
	case "delete":
		$.ajax({
			type : "post",
		  //  headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
			url : "/employees/delete",
			data : "employee_id="+$("#employee_id").val(),
			success : function(res) {
				if (res == 1) {
					$("#msg").removeClass("alert-danger").addClass("alert-success");
					$("#msg").show();
					$("#msg").html("Registro eliminado correctamente.");
				} else {
					$("#msg").show();
					$("#msg").html("No se pudo eliminar el registro.");
				}
			},
			error : function() {
				$("#msg").show();
				$("#msg").html("No se pudo eliminar el registro.");
			}
		});
		break;
	default:
		$("#msg").show();
		$("#msg").html("Opción incorrecta.");
	}
}
