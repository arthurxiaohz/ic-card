/**
 * @requires jquery.validate.js
 * @author ZhangHuihua@msn.com
 */
(function($){
	$.validator.addMethod("alphanumeric", function(value, element) {
		return this.optional(element) || /^\w+$/i.test(value);
	}, "Letters, numbers or underscores only please");
	
	$.validator.addMethod("lettersonly", function(value, element) {
		return this.optional(element) || /^[a-z]+$/i.test(value);
	}, "Letters only please"); 
	
	$.validator.addMethod("phone", function(v, element) {
	    v = v.replace(/\s+/g, ""); 
		return this.optional(element) || v.match(/^[0-9 \(\)]{7,30}$/);
	}, "Please specify a valid phone number");
	
	$.validator.addMethod("postcode", function(v, element) {
	    v = v.replace(/\s+/g, ""); 
		return this.optional(element) || v.match(/^[0-9 A-Za-z]{5,20}$/);
	}, "Please specify a valid postcode");
	
	$.validator.addMethod("date", function(v, element) {
	    v = v.replace(/\s+/g, ""); 
		return this.optional(element) || v.match(/^\d{4}[\/-]\d{1,2}[\/-]\d{1,2}$/);
	});
	
	$.validator.addMethod("mobile", function(v, element) {
	    v = v.replace(/\s+/g, ""); 
		return this.optional(element) || v.match(/^(13[0-9]|15[0-9]|168|189)\d{8}$/);
	},"Please specify a valid mobile number");
	
	$.validator.addClassRules({
		date: {date: false},
		alphanumeric: { alphanumeric: true },
		lettersonly: { lettersonly: true },
		phone: { phone: true },
		postcode: {postcode: true},
		mobile: {mobile: true},
		float: {number: true},
		integer: {digits: true}
	});
	$.validator.setDefaults({errorElement:"span"});
	$.validator.autoCreateRanges = true;

})(jQuery);