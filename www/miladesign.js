module.exports = {
	// Show ProgressDialog
	ShowProgressDialog: function(title,message) {
		cordova.exec(
			function (result) {
			}, 
			function (error) {
			},
			'AndroidTools',
			'progressShow',			
			[title,message]
		); 
	},
	
	// Hide ProgressDialog
	HideProgressDialog: function() {
		cordova.exec(
			function (result) {
			}, 
			function (error) {
			},
			'AndroidTools',
			'progressHide',			
			[]
		); 
	}
};
