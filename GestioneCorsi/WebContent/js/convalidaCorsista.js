$(document).ready(function() {
	$('#corsistaForm').bootstrapValidator({
		feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
		},
		fields: {
			nome: {
				container: '#infoNome',
				validators: {
					notEmpty: {
						message: 'Il campo nome non pu&ograve; essere vuoto'
					},
					regexp: {
						regexp: /^[a-zA-Z ,.'-]{2,30}$/,
						message: 'Da 2 a 30 caratteri (Solo lettere accettate)'
					}
				}
			},
			cognome: {
				container: '#infoCognome',
				validators: {
					notEmpty: {
						message: 'Il campo cognome non pu&ograve; essere vuoto'
					},
					regexp: {
						regexp: /^[a-zA-Z ,.'-]{2,30}$/,
						message: 'Da 2 a 30 caratteri (Solo lettere accettate)'
					}
				}
			}
		}
	});
});