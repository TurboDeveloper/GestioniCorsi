var inizio= $("#datainizio").val();
var fine=$("#datafine").val();
if(fine<inizio){
	$("#infoDatafine").val("Attenzione! data di fine corso precedente a quella di inizio!");
	$("#infoDatainizio").val("Attenzione! data di fine corso precedente a quella di inizio!");
}