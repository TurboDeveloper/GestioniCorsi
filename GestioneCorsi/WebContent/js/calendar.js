$(function () {
					$('#dp').datepicker({
						format: 'dd/mm/yyyy',
						autoclose: true,
						startDate: '01/01/1900',
						endDate: new Date()
					}).on(
						'changeDate',
						function (e) {
							$("#userForm").bootstrapValidator(
								'revalidateField', 'nascita');
						});
				});