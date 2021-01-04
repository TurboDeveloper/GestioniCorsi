$(function () {
	$('#dp1').datepicker({
		format: 'dd/mm/yyyy',
		autoclose: true,
		startDate: '01/01/1900',
		endDate: new Date()
	}).on(
		'changeDate',
		function (e) {
			$("#corsoForm").bootstrapValidator(
				'revalidateField', 'datainizio');
		});
		$('#dp2').datepicker({
			format: 'dd/mm/yyyy',
			autoclose: true,
			startDate: '01/01/1900',
			endDate: new Date()
		}).on(
			'changeDate',
			function (e) {
				$("#corsoForm").bootstrapValidator(
					'revalidateField', 'datafine');
			});
});