function sendContact(form){
	var output;
	
	var post_data = {		    
		'email'		: $('input[name=email]').val(),
		'subject'	: $('input[name=subject]').val(),
		'message'	: $('textarea[name=message]').val()
	}
	
	var request = $.ajax({
		url: $("#context").val() + "/contact/insert",
		method: "POST",
		contentType: "application/json;",
		data: JSON.stringify(post_data)
	});
	 
	request.done(function(response, status) {
		 output = '<div class="success">Message inserted successfully!</div>';
		 $("#contacts_form .form_item").val('');
	});
	 
	request.fail(function(response, status) {			  
		output = '<div class="error_block">' + response.statusText + '</div>';
	});
	
	request.always(function(response, status) {
		form.find('.form_row').slideUp();
	    form.find("#contact_results").hide().html(output).slideDown();
	});
}