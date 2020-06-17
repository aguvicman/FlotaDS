function ViajesController(opcion) {
	$("#msg").show();
	$("#msg").removeClass("alert-success").addClass("alert-danger");
	var token = $("meta[name='_csrf']").attr("content");

	switch(opcion){
	case "list":
		$.ajax({
			type : "post",
			headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
			url : "/viaje/list",
			success : function(res) {
				$('#viajeTable').bootstrapTable('load', res);
				$('#viajeTable tbody').on('click', 'tr', function () {
					alert("100");
					$("#viaje_id").val($(this).find("td:eq(0)").text());
					$("#cliente_id").val($(this).find("td:eq(1)").text());
					$("#tipoviaje_id").val($(this).find("td:eq(2)").text());
					$("#region_id").val($(this).find("td:eq(3)").text());
					$("#comuna_id").val($(this).find("td:eq(4)").text());
					$("#vehiculo_ppu").val($(this).find("td:eq(5)").text());
					$("#conductor_id").val($(this).find("td:eq(6)").text());
					$("#viaje_fecha").val($(this).find("td:eq(7)").text());
					$("#tipopago_id").val($(this).find("td:eq(8)").text());
					$("#costo").val($(this).find("td:eq(9)").text());
					$("#myModal .close").click();
				});
				$("#myModal").modal({show:true});
			},
			error : function() {
				$("#msg").show();
				$("#msg").html("Error en busqueda de Viajes.")
			}
		});       			
		break;
	case "get":
		$.ajax({
			type : "post",
			headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
			url : "/viaje/get",
			data : "viaje_id="+$("#viaje_id").val(),
			success : function(res) {
				if (res == null || res == "") {
					$("#msg").show();
					$("#msg").html("No se encontraron registros.");
				} else {	
					$("#viaje_id").val(res.viaje_id);
					$("#cliente_id").val(res.cliente_id);
					$("#tipoviaje_id").val(res.tipoviaje_id);
					$("#region_id").val(res.region_id);
					$("#comuna_id").val(res.comuna_id);
					$("#vehiculo_ppu").val(res.vehiculo_ppu);
					$("#conductor_id").val(res.conductor_id);
					$("#viaje_fecha").val(res.viaje_fecha);
					$("#tipopago_id").val(res.tipopago_id);
					$("#costo").val(res.costo);
					
				}
			},
			error : function() {
				$("#msg").show();
				$("#msg").html("Error en busqueda.");
			}
		});       			
		break;
	case "insert":
		var json = 
			{
				'viaje_id': $("#viaje_id").val(),
				'cliente_id': $("#cliente_id").val(),
				'tipoviaje_id': $("#tipoviaje_id").val(),
				'region_id': $("#region_id").val(),
				'comuna_id': $("#comuna_id").val(),
				'vehiculo_ppu': $("#vehiculo_ppu").val(),
				'conductor_id': $("#conductor_id").val(),
				'viaje_fecha': ( $("#viaje_fecha").val() ? $("#viaje_fecha").val() : "0"),
				'tipopago_id': ( $("#tipopago_id").val() ? $("#tipopago_id").val() : "0"),
				'costo': $("#costo").val()
			};
	
	    var postData = JSON.stringify(json);

	    $.ajax({
			type : "post",
			headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
			url : "/viaje/insert",
			data : postData,
			contentType : "application/json; charset=utf-8",
	        dataType : "json",
			success : function(res) {
				if (res == 1) {
					$("#msg").removeClass("alert-danger").addClass("alert-success");
					$("#msg").show();
					$("#msg").html("Registro ingresado correctamente.");
				} else {
					$("#msg").show();
					$("#msg").html("No se pudo ingresar el registro.");
				}
			},
			error : function() {
				$("#msg").show();
				$("#msg").html("No se pudo ingresar el registro.");
			}
		});       	
	    break;
	case "update":
		var json = 
			{
				'viaje_id': $("#viaje_id").val(),
				'cliente_id': $("#cliente_id").val(),
				'tipoviaje_id': $("#tipoviaje_id").val(),
				'region_id': $("#region_id").val(),
				'comuna_id': $("#comuna_id").val(),
				'vehiculo_ppu': $("#vehiculo_ppu").val(),
				'conductor_id': $("#conductor_id").val(),
				'viaje_fecha': ( $("#viaje_fecha").val() ? $("#viaje_fecha").val() : "0"),
				'tipopago_id': ( $("#tipopago_id").val() ? $("#tipopago_id").val() : "0"),
				'costo': $("#costo").val()
			};
		;

	    var postData = JSON.stringify(json);

		$.ajax({
			type : "post",
			headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
			url : "/viaje/update",
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
			headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
			url : "/viaje/delete",
			data : "viaje_id="+$("#viaje_id").val(),
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