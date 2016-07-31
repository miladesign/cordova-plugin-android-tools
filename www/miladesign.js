var exec = require('cordova/exec');
module.exports = {
	// Show ProgressDialog
	ShowProgressDialog: function(title,message) {
		cordova.exec(
			null, 
			null,
			'AndroidTools',
			'progressShow',			
			[title,message]
		); 
	},
	
	// Hide ProgressDialog
	HideProgressDialog: function() {
		cordova.exec(
			null, 
			null,
			'AndroidTools',
			'progressHide',			
			[]
		); 
	},
	
	// Show Dialog
	ShowDialog: function(title,message,button) {
		cordova.exec(
			null, 
			null,
			'AndroidTools',
			'dialogShow',			
			[title,message,button]
		); 
	},
	
	// Exit Dialog
	ExitDialog: function(title,message,btnYes,btnNo) {
		cordova.exec(
			null, 
			null,
			'AndroidTools',
			'exitDialog',			
			[title,message,btnYes,btnNo]
		); 
	},
	
	// Show Toast
	ShowToast: function(message) {
		cordova.exec(
			null, 
			null,
			'AndroidTools',
			'showToast',			
			[message]
		); 
	},
	
	// Get Device Unique ID
	GetDeviceID: function(success, fail) {
        cordova.exec(success, fail, 'AndroidTools', 'getDeviceId', []);
    },
	
	// Bazaar Rate App
	BazaarRate: function(packageName) {
		cordova.exec(
			null,
			null,
			'AndroidTools',
			'bazaarRate',			
			[packageName]
		); 
	},
	
	// Bazaar Show App
	BazaarApp: function(packageName) {
		cordova.exec(
			null,
			null,
			'AndroidTools',
			'bazaarApp',			
			[packageName]
		); 
	},
	
	// Bazaar Developer page
	BazaarDeveloper: function(userName) {
		cordova.exec(
			null,
			null,
			'AndroidTools',
			'bazaarDeveloper',			
			[userName]
		); 
	},
	
	// Myket Rate App
	MyketRate: function(packageName) {
		cordova.exec(
			null,
			null,
			'AndroidTools',
			'myketRate',			
			[packageName]
		); 
	},
	
	// Myket Show App
	MyketApp: function(packageName) {
		cordova.exec(
			null,
			null,
			'AndroidTools',
			'myketApp',			
			[packageName]
		); 
	},
	
	// Myket Developer page
	MyketDeveloper: function(packageName) {
		cordova.exec(
			null,
			null,
			'AndroidTools',
			'myketDeveloper',			
			[packageName]
		); 
	},
	
	// IranApps Rate App
	IranAppsRate: function(packageName) {
		cordova.exec(
			null,
			null,
			'AndroidTools',
			'iranappsRate',			
			[packageName]
		); 
	},
	
	// IranApps Show App
	IranAppsApp: function(packageName) {
		cordova.exec(
			null,
			null,
			'AndroidTools',
			'iranappsApp',			
			[packageName]
		); 
	},
	
	// IranApps Developer page
	IranAppsDeveloper: function(userName) {
		cordova.exec(
			null,
			null,
			'AndroidTools',
			'iranappsDeveloper',			
			[userName]
		); 
	},
	
	// Cando Rate App
	CandoRate: function(packageName) {
		cordova.exec(
			null,
			null,
			'AndroidTools',
			'candoRate',			
			[packageName]
		); 
	},
	
	// Cando Show App
	CandoApp: function(packageName) {
		cordova.exec(
			null,
			null,
			'AndroidTools',
			'candoApp',			
			[packageName]
		); 
	},
	
	// Cando Developer page
	CandoDeveloper: function(userName) {
		cordova.exec(
			null,
			null,
			'AndroidTools',
			'candoDeveloper',			
			[userName]
		); 
	},
	
	// Parshub Rate App
	ParshubRate: function(packageName) {
		cordova.exec(
			null,
			null,
			'AndroidTools',
			'parshubRate',			
			[packageName]
		); 
	},
	
	// Parshub Show App
	ParshubApp: function(packageName) {
		cordova.exec(
			null,
			null,
			'AndroidTools',
			'parshubApp',			
			[packageName]
		); 
	},
	
	// Parshub Developer page
	ParshubDeveloper: function(UserName) {
		cordova.exec(
			null,
			null,
			'AndroidTools',
			'parshubDeveloper',			
			[UserName]
		); 
	},
	
	// All Markets App
	AllMarketsApp: function(packageName) {
		cordova.exec(
			null,
			null,
			'AndroidTools',
			'allMarketsApp',			
			[packageName]
		); 
	},
	
	// AvvalMarket Rate
	AvvalMarketRate: function(packageName) {
		cordova.exec(
			null,
			null,
			'AndroidTools',
			'avvalMarketRate',			
			[packageName]
		); 
	},
	
	// Telegram Profile
	TelegramProfile: function(UserName) {
		cordova.exec(
			null,
			null,
			'AndroidTools',
			'telegramProfile',			
			[UserName]
		); 
	},
	
	// Instagram Profile
	InstagramProfile: function(UserName) {
		cordova.exec(
			null,
			null,
			'AndroidTools',
			'instagramProfile',			
			[UserName]
		); 
	},
	
	// Share Text
	ShareText: function(title,text) {
		cordova.exec(
			null,
			null,
			'AndroidTools',
			'shareText',			
			[title,text]
		); 
	},
	
	// Share App
	ShareApp: function(title,packageName) {
		cordova.exec(
			null,
			null,
			'AndroidTools',
			'shareApp',			
			[title,packageName]
		); 
	}
};
