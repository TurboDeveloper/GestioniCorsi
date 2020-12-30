$(function () {
					$('.input-group date').datepicker({
						format: 'dd/mm/yyyy',
						autoclose: true,
						startDate: '01/01/1900',
						endDate: new Date()
					}).on(
						'changeDate',
						function (e) {
							$("#corsoForm").bootstrapValidator(
								'revalidateField', 'nascita');
						});
				});