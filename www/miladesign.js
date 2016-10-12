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
	ShowToast: function(message,duration) {
		cordova.exec(
			null, 
			null,
			'AndroidTools',
			'showToast',			
			[message,duration]
		); 
	},
	
	// Show Custom Toast
	CustomToast: function(message,duration,type) {
		cordova.exec(
			null, 
			null,
			'AndroidTools',
			'customToast',			
			[message,duration,type]
		); 
	},
	
	// Vibrate Device
	VibrateDevice: function(duration) {
		cordova.exec(
			null, 
			null,
			'AndroidTools',
			'vibrateDevice',			
			[duration]
		); 
	},
	
	// Vibrate Supported
	VibrateSupported: function() {
		var self = this;
		cordova.exec(
			function (result) {
                if (typeof result == "string") {
                    if (result == "onVibrateSupported") {
                        if (self.onVibrateSupported) {
                            self.onVibrateSupported();
                        }
                    }
                    if (result == "onVibrateNotSupported") {
                        if (self.onVibrateNotSupported) {
                            self.onVibrateNotSupported();
                        }
                    }
                }
            }, 
			null,
			'AndroidTools',
			'vibrate_supported',			
			[]
		); 
	},
	
	// Check Bazaar
	CheckBazaar: function() {
		var self = this;
		cordova.exec(
			function (result) {
                if (typeof result == "string") {
                    if (result == "onBazaarTrue") {
                        if (self.onBazaarTrue) {
                            self.onBazaarTrue();
                        }
                    }
                    if (result == "onBazaarFalse") {
                        if (self.onBazaarFalse) {
                            self.onBazaarFalse();
                        }
                    }
                }
            },
			null,
			'AndroidTools',
			'checkBazaar',			
			[]
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
	
	// Open Url
	OpenUrl: function(url) {
		cordova.exec(
			null,
			null,
			'AndroidTools',
			'openUrl',			
			[url]
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
	},
	
	// Opem App
	OpenApp: function(packageName) {
		cordova.exec(
			null,
			null,
			'AndroidTools',
			'openApp',			
			[packageName]
		); 
	},
	onVibrateSupported: null,
	onVibrateNotSupported: null,
	onBazaarTrue: null,
	onBazaarFalse: null
};
