webpackJsonp(["main"],{

/***/ "./src/$$_lazy_route_resource lazy recursive":
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncatched exception popping up in devtools
	return Promise.resolve().then(function() {
		throw new Error("Cannot find module '" + req + "'.");
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./src/app/app-routing.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppRoutingModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__welcome_welcome_component__ = __webpack_require__("./src/app/welcome/welcome.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__menu_menu_component__ = __webpack_require__("./src/app/menu/menu.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};




var routes = [
    { path: 'welcome', component: __WEBPACK_IMPORTED_MODULE_2__welcome_welcome_component__["a" /* WelcomeComponent */] },
    { path: 'menu/:category', component: __WEBPACK_IMPORTED_MODULE_3__menu_menu_component__["a" /* MenuComponent */] },
    { path: 'menu/:category/:page', component: __WEBPACK_IMPORTED_MODULE_3__menu_menu_component__["a" /* MenuComponent */] }
];
var AppRoutingModule = /** @class */ (function () {
    function AppRoutingModule() {
    }
    AppRoutingModule = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["I" /* NgModule */])({
            imports: [__WEBPACK_IMPORTED_MODULE_1__angular_router__["b" /* RouterModule */].forRoot(routes)],
            exports: [__WEBPACK_IMPORTED_MODULE_1__angular_router__["b" /* RouterModule */]]
        })
    ], AppRoutingModule);
    return AppRoutingModule;
}());



/***/ }),

/***/ "./src/app/app.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/app.component.html":
/***/ (function(module, exports) {

module.exports = "<form action=\"/logout\" method=\"post\" id=\"logoutForm\">\n    <input type=\"hidden\" name=\"\"\n           value=\"\"/>\n</form>\n\n<nav class=\"navbar navbar-expand-md navbar-dark bg-dark\">\n    <button class=\"navbar-toggler navbar-toggler-right\" type=\"button\" data-toggle=\"collapse\"\n            data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\"\n            aria-label=\"Toggle navigation\">\n        <span class=\"navbar-toggler-icon\"></span>\n    </button>\n    <a class=\"navbar-brand\" href=\"/welcome\"><img src=\"/assets/images/logo.png\"></a>\n    <div class=\"navbar-collapse collapse\" id=\"navbarSupportedContent\">\n        <ul class=\"navbar-nav mr-auto\">\n            <li  *ngFor=\"let category of categories\" class=\"nav-item\">\n                <a class=\"nav-link\" [routerLink]=\"['menu', category.name]\" routerLinkActive=\"active\" >{{category.name}}</a>\n            </li>\n            <button type=\"button\" class=\"btn btn-success nav-button\" style=\"margin-right:10px;\"\n                    data-toggle=\"modal\" data-target=\"#exampleModalWaiter\">\n                <span class=\"left-span\"> Call a waiter  <i class=\"fa fa-bell\" aria-hidden=\"true\"></i></span>\n            </button>\n             <!--\n\n            <li>\n                <c:if test=\"${not empty orderMap || not empty orderedList}\">\n                    <a href=\"/order\">\n                        <button class=\"btn btn-info nav-button\" style=\"margin-right:10px;\">\n                            <span class=\"left-span\">Order  <i class=\"fa fa-coffee\" aria-hidden=\"true\"></i></span>\n                        </button>\n                    </a>\n                </c:if>\n                <c:if test=\"${empty orderMap && empty orderedList}\">\n                    <button class=\"btn btn-info nav-button\" disabled style=\"margin-right:10px;\">\n                        <span class=\"left-span\">Order  <i class=\"fa fa-coffee\" aria-hidden=\"true\"></i></span>\n                    </button>\n                </c:if>\n                Your table is ${tables.currentTable}\n            </li>\n               //-->\n        </ul>\n    </div>\n        <form action=\"/menu\" method=\"get\" class=\"form-inline\">\n            <input class=\"form-control mr-sm-2\" name=\"search\" type=\"text\" placeholder=\"Search dish\"/>\n            <button type=\"submit\" class=\"btn btn-default btn-lg nav-button btn-nav-search\" style=\"margin-top: 10px\">\n                <i class=\"fa fa-search\"></i>\n            </button>\n        </form>\n            <!--\n\n        <c:if test=\"${pageContext.request.userPrincipal.name != null}\">\n            <h6 style=\"color: lightgrey\">\n                Hi, ${pageContext.request.userPrincipal.name}\n                <a href=\"javascript:formSubmit()\"> Logout</a>\n            </h6>\n        </c:if>\n        <c:if test=\"${pageContext.request.userPrincipal.name == null}\">\n            <a class=\"nav-link a-nav\" href=\"/login\">Log in <i class=\"fa fa-user\" aria-hidden=\"true\"></i></a>\n        </c:if>\n        //-->\n\n        </nav>\n\n<router-outlet></router-outlet>\n\n<footer class=\"footer\">\n    <div class=\"container\">\n        <span class=\"add-text\"> RestHub Inc. \t&#169;</span>\n        <a href=\"#\" class=\"add-text\">Contact us </a>\n        <span class=\"align-middle\">Join us\n              <button class=\"i-button\" style=\"margin-left: 20px\">\n                  <i class=\"fa fa-facebook\" aria-hidden=\"true\"></i></button>\n        <button class=\"i-button\"><i class=\"fa fa-twitter\" aria-hidden=\"true\"></i></button>\n            <button class=\"i-button\"><i class=\"fa fa-instagram\" aria-hidden=\"true\"></i></button>\n        </span>\n        <a href=\"#\" class=\"add-text\">Help</a>\n    </div>\n</footer>\n"

/***/ }),

/***/ "./src/app/app.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__services_app_service__ = __webpack_require__("./src/app/services/app.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var AppComponent = /** @class */ (function () {
    function AppComponent(appService) {
        this.appService = appService;
    }
    AppComponent.prototype.ngOnInit = function () {
        this.getCategories();
    };
    AppComponent.prototype.getCategories = function () {
        var _this = this;
        this.appService.getCategories().subscribe(function (res) { return _this.categories = res; });
    };
    AppComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-root',
            template: __webpack_require__("./src/app/app.component.html"),
            styles: [__webpack_require__("./src/app/app.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__services_app_service__["a" /* AppService */]])
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "./src/app/app.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* unused harmony export API_URL */
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__ = __webpack_require__("./node_modules/@angular/platform-browser/esm5/platform-browser.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__app_routing_module__ = __webpack_require__("./src/app/app-routing.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__app_component__ = __webpack_require__("./src/app/app.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__welcome_welcome_component__ = __webpack_require__("./src/app/welcome/welcome.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__services_welcome_service__ = __webpack_require__("./src/app/services/welcome.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__angular_common_http__ = __webpack_require__("./node_modules/@angular/common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__services_app_service__ = __webpack_require__("./src/app/services/app.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__environments_environment__ = __webpack_require__("./src/environments/environment.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__menu_menu_component__ = __webpack_require__("./src/app/menu/menu.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__services_menu_service__ = __webpack_require__("./src/app/services/menu.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};











var API_URL = new __WEBPACK_IMPORTED_MODULE_1__angular_core__["B" /* InjectionToken */]('apiUrl');
var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["I" /* NgModule */])({
            declarations: [
                __WEBPACK_IMPORTED_MODULE_3__app_component__["a" /* AppComponent */],
                __WEBPACK_IMPORTED_MODULE_4__welcome_welcome_component__["a" /* WelcomeComponent */],
                __WEBPACK_IMPORTED_MODULE_9__menu_menu_component__["a" /* MenuComponent */]
            ],
            imports: [
                __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__["a" /* BrowserModule */],
                __WEBPACK_IMPORTED_MODULE_2__app_routing_module__["a" /* AppRoutingModule */],
                __WEBPACK_IMPORTED_MODULE_6__angular_common_http__["b" /* HttpClientModule */],
            ],
            providers: [__WEBPACK_IMPORTED_MODULE_5__services_welcome_service__["a" /* WelcomeService */], __WEBPACK_IMPORTED_MODULE_6__angular_common_http__["a" /* HttpClient */], __WEBPACK_IMPORTED_MODULE_7__services_app_service__["a" /* AppService */], __WEBPACK_IMPORTED_MODULE_10__services_menu_service__["a" /* MenuService */],
                { provide: "API_URL", useValue: __WEBPACK_IMPORTED_MODULE_8__environments_environment__["a" /* environment */].apiUrl }
            ],
            bootstrap: [__WEBPACK_IMPORTED_MODULE_3__app_component__["a" /* AppComponent */]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/menu/menu.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/menu/menu.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container\">\n\n    <div class=\"col1\" style=\"text-align: right; padding-top: 10px;\">\n        <div class=\"btn-group\">\n            <button type=\"button\" class=\"btn btn-secondary dropdown-toggle\" data-toggle=\"dropdown\" aria-haspopup=\"true\"\n                    aria-expanded=\"false\">\n                Sort by\n            </button>\n        </div>\n    </div>\n\n    <div class=\"row1\">\n      <div class=\"col-sm-3\" *ngFor=\"let dish of dishes\">\n        <div class=\"card\">\n            \n          <a href=\"/dish/{{dish.id}}\">\n            <div id=\"dishCarousel${{dish.id}}\" class=\"carousel slide card-img-top\" data-interval=\"false\" data-ride=\"carousel\">\n            <div class=\"carousel-inner\">\n                <div class=\"carousel-item active\">\n                    <img class=\"d-block w-100\" src=\"{{dish.images[0].url}}\" alt=\"{{dish.name}}\">\n                </div>\n            </div>\n            <a class=\"carousel-control-prev\" href=\"#dishCarousel${item.id}\" role=\"button\" data-slide=\"prev\">\n                <span class=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span>\n                <span class=\"sr-only\">Previous</span>\n            </a>\n            <a class=\"carousel-control-next\" href=\"#dishCarousel${item.id}\" role=\"button\" data-slide=\"next\">\n                <span class=\"carousel-control-next-icon\" aria-hidden=\"true\"></span>\n                <span class=\"sr-only\">Next</span>\n            </a>\n            </div>\n        </a>\n\n        <div class=\"card-body\">\n            <h4 class=\"card-title\">{{dish.name}}</h4>\n            <p class=\"card-text\">{{dish.description}}</p>\n        </div>\n\n        <div class=\"card-footer\">\n            <h5 class=\"card-title inline\">{{dish.price}}$</h5>\n            <a href=\"/addToOrder/${item.id}\" class=\"btn btn-primary inline\">Add to cart</a>\n        </div>\n        </div>\n      </div>\n    </div>\n    <div class=\"menuPagination\">\n        <nav aria-label=\"RestHub menu pagination\">\n          <ul class=\"pagination\">\n              <li class=\"page-item\" [ngClass]=\"{'disabled': 1 == currPage}\">\n                <a class=\"page-link\" href=\"/menu/{{category}}/{{currPage - 1}}\" aria-label=\"Previous\">\n                    <span aria-hidden=\"true\">&laquo;</span>\n                    <span class=\"sr-only\">Previous</span>\n                </a>\n              </li>\n                <li class=\"page-item\" *ngFor=\"let number of numbers\" [ngClass]=\"{'active': number == currPage}\" >\n                    <a class=\"page-link\" href=\"/menu/{{category}}/{{number}}\">{{number}}</a>\n                </li>\n                <li class=\"page-item\" [ngClass]=\"{'disabled': maxPage == currPage}\">\n                    <a class=\"page-link\" href=\"/menu/{{category}}/{{currPage + 1}}\" aria-label=\"Next\">\n                    <span aria-hidden=\"true\">&raquo;</span>\n                    <span class=\"sr-only\">Next</span>\n                </a>\n            </li>\n        </ul>\n        </nav>\n    </div>\n</div>\n\n<style>\n  .row1 {\n   display: flex;\n   flex-wrap: wrap;\n}\n\n.row1 > div[class*='col-'] {\n  display: flex;\n}\n\n</style>"

/***/ }),

/***/ "./src/app/menu/menu.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return MenuComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__services_menu_service__ = __webpack_require__("./src/app/services/menu.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var MenuComponent = /** @class */ (function () {
    function MenuComponent(route, menuService) {
        var _this = this;
        this.route = route;
        this.menuService = menuService;
        this.route.params.subscribe(function (params) {
            _this.category = params['category'],
                _this.currPage = Number(params['page']);
        });
        if (!this.currPage) {
            this.currPage = 1;
        }
    }
    MenuComponent.prototype.ngOnInit = function () {
        this.getDishes();
    };
    MenuComponent.prototype.getDishes = function () {
        var _this = this;
        this.menuService.getDishesByCategory(this.category, this.currPage).subscribe(function (res) {
            _this.dishes = res.body;
            _this.maxPage = Number(res.headers.get('last'));
            _this.numbers = Array(_this.maxPage).fill(1).map(function (x, i) { return i + 1; });
        });
    };
    MenuComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-menu',
            template: __webpack_require__("./src/app/menu/menu.component.html"),
            styles: [__webpack_require__("./src/app/menu/menu.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_router__["a" /* ActivatedRoute */], __WEBPACK_IMPORTED_MODULE_2__services_menu_service__["a" /* MenuService */]])
    ], MenuComponent);
    return MenuComponent;
}());



/***/ }),

/***/ "./src/app/services/app.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common_http__ = __webpack_require__("./node_modules/@angular/common/esm5/http.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var __param = (this && this.__param) || function (paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
};


var AppService = /** @class */ (function () {
    function AppService(categoryApi, http) {
        this.categoryApi = categoryApi;
        this.http = http;
    }
    AppService.prototype.getCategories = function () {
        return this.http.get(this.categoryApi + 'category/all');
    };
    AppService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["A" /* Injectable */])(),
        __param(0, Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["z" /* Inject */])('API_URL')),
        __metadata("design:paramtypes", [String, __WEBPACK_IMPORTED_MODULE_1__angular_common_http__["a" /* HttpClient */]])
    ], AppService);
    return AppService;
}());



/***/ }),

/***/ "./src/app/services/menu.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return MenuService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common_http__ = __webpack_require__("./node_modules/@angular/common/esm5/http.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var __param = (this && this.__param) || function (paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
};


var MenuService = /** @class */ (function () {
    function MenuService(rootApi, http) {
        this.rootApi = rootApi;
        this.http = http;
    }
    MenuService.prototype.getDishesByCategory = function (category, page) {
        var params = new __WEBPACK_IMPORTED_MODULE_1__angular_common_http__["c" /* HttpParams */]()
            .set('page', String(page));
        return this.http.get(this.rootApi + 'dish/by' + category, { params: params, observe: 'response' });
    };
    MenuService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["A" /* Injectable */])(),
        __param(0, Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["z" /* Inject */])('API_URL')),
        __metadata("design:paramtypes", [String, __WEBPACK_IMPORTED_MODULE_1__angular_common_http__["a" /* HttpClient */]])
    ], MenuService);
    return MenuService;
}());



/***/ }),

/***/ "./src/app/services/welcome.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return WelcomeService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common_http__ = __webpack_require__("./node_modules/@angular/common/esm5/http.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var Category = /** @class */ (function () {
    function Category() {
    }
    return Category;
}());
var WelcomeService = /** @class */ (function () {
    function WelcomeService(http) {
        this.http = http;
        this.url = "http://localhost:8080/api/hello";
    }
    WelcomeService.prototype.getWithPromise = function () {
        return this.http.get(this.url, { responseType: 'text' }).toPromise()
            .then(this.extractData.toString);
    };
    WelcomeService.prototype.extractData = function (res) {
        var body = res.text();
        return body;
    };
    WelcomeService.prototype.handleError = function (error) {
        console.error('Some error occured', error);
        return Promise.reject(error.message || error);
    };
    WelcomeService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["A" /* Injectable */])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_common_http__["a" /* HttpClient */]])
    ], WelcomeService);
    return WelcomeService;
}());



/***/ }),

/***/ "./src/app/welcome/welcome.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/welcome/welcome.component.html":
/***/ (function(module, exports) {

module.exports = "<div id=\"demo\" class=\"carousel slide\" data-ride=\"carousel\">\n  <ul class=\"carousel-indicators\">\n      <li data-target=\"#demo\" data-slide-to=\"0\" class=\"active\"></li>\n      <li data-target=\"#demo\" data-slide-to=\"1\"></li>\n      <li data-target=\"#demo\" data-slide-to=\"2\"></li>\n  </ul>\n  <div class=\"carousel-inner\">\n      <div class=\"carousel-item active\">\n          <img src=\"/assets/images/CUT3M37NQM.jpg\" alt=\"Carry\" class=\"fluid\" width=\"100%\">\n          <div class=\"carousel-caption\">\n              <h1>Welcome!</h1>\n              <br><br><br>\n              <h3>Italian pizza</h3>\n          </div>\n      </div>\n      <div class=\"carousel-item\">\n            <img src=\"/assets/images/CUTsauteed-shrimp-topped-with-roasted-red-pepper-sauce-in-pan_2.jpg\" alt=\"Shrimps\"\n               class=\"fluid\" width=\"100%\">\n          <div class=\"carousel-caption\">\n              <h1>Welcome!</h1>\n              <br><br><br>\n              <h3>Sauteed shrimps</h3>\n          </div>\n      </div>\n      <div class=\"carousel-item\">\n          <img src=\"/assets/images/CUTharissa.jpg\" alt=\"Harissa\" class=\"fluid\" width=\"100%\">\n          <div class=\"carousel-caption\">\n              <h1>Welcome!</h1>\n              <br><br><br>\n              <h3>Harissa fries</h3>\n          </div>\n      </div>\n  </div>\n  <a class=\"carousel-control-prev\" href=\"#demo\" data-slide=\"prev\">\n      <span class=\"carousel-control-prev-icon\"></span>\n  </a>\n  <a class=\"carousel-control-next\" href=\"#demo\" data-slide=\"next\">\n      <span class=\"carousel-control-next-icon\"></span>\n  </a>\n</div>\n<div class=\"container\">\n  <div class=\"row\">\n      <a href=\"\\waiter\\tables\" class=\"btn btn-warning btn-lg btn-block\">Waiter</a>\n      <a href=\"\\cooker\" class=\"btn btn-warning btn-lg btn-block\">Cook</a>\n      <a href=\"\\admin\" class=\"btn btn-warning btn-lg btn-block\">Administrator</a>\n      <a href=\"\\menu\\soups\" class=\"btn btn-warning btn-lg btn-block\">User</a>\n\n  </div>\n</div>\n<!-- Modal -->\n\n<style>\n  .row {\n      padding: 15pt;\n  }\n\n  .btn-block {\n      padding: 10pt;\n  }\n\n</style>"

/***/ }),

/***/ "./src/app/welcome/welcome.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return WelcomeComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var WelcomeComponent = /** @class */ (function () {
    function WelcomeComponent() {
    }
    WelcomeComponent.prototype.ngOnInit = function () {
    };
    WelcomeComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-welcome',
            template: __webpack_require__("./src/app/welcome/welcome.component.html"),
            styles: [__webpack_require__("./src/app/welcome/welcome.component.css")]
        }),
        __metadata("design:paramtypes", [])
    ], WelcomeComponent);
    return WelcomeComponent;
}());



/***/ }),

/***/ "./src/environments/environment.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return environment; });
// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.
var environment = {
    production: false,
    apiUrl: "http://localhost:8080/api/"
};


/***/ }),

/***/ "./src/main.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__ = __webpack_require__("./node_modules/@angular/platform-browser-dynamic/esm5/platform-browser-dynamic.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__app_app_module__ = __webpack_require__("./src/app/app.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__environments_environment__ = __webpack_require__("./src/environments/environment.ts");




if (__WEBPACK_IMPORTED_MODULE_3__environments_environment__["a" /* environment */].production) {
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_12" /* enableProdMode */])();
}
Object(__WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__["a" /* platformBrowserDynamic */])().bootstrapModule(__WEBPACK_IMPORTED_MODULE_2__app_app_module__["a" /* AppModule */])
    .catch(function (err) { return console.log(err); });


/***/ }),

/***/ 0:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__("./src/main.ts");


/***/ })

},[0]);
//# sourceMappingURL=main.bundle.js.map