$(document).ready(function(){
	$('#loginForm').bootstrapValidator({
		feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
		},
		fields : {
			cod_admin: {
				container: '#infoCod_admin',
				validators: {
					notEmpty: {
						message: 'Il campo username non pu&ograve; essere vuoto'
					},
					regexp: {
						regexp: /^[1-9]{1,10}$/,
						message: 'numeri accettati, da 1 a 9 '
					}
				}				
			}
		}
	});
});