(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["views-historia-historia-module"],{

/***/ "./src/app/views/historia/historia-routing.module.ts":
/*!***********************************************************!*\
  !*** ./src/app/views/historia/historia-routing.module.ts ***!
  \***********************************************************/
/*! exports provided: HistoriaRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "HistoriaRoutingModule", function() { return HistoriaRoutingModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _ingreso_ingreso_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./ingreso/ingreso.component */ "./src/app/views/historia/ingreso/ingreso.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};



var routes = [
    {
        path: 'altaPaciente',
        component: _ingreso_ingreso_component__WEBPACK_IMPORTED_MODULE_2__["IngresoComponent"],
    }
];
var HistoriaRoutingModule = /** @class */ (function () {
    function HistoriaRoutingModule() {
    }
    HistoriaRoutingModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
        })
    ], HistoriaRoutingModule);
    return HistoriaRoutingModule;
}());



/***/ }),

/***/ "./src/app/views/historia/historia.module.ts":
/*!***************************************************!*\
  !*** ./src/app/views/historia/historia.module.ts ***!
  \***************************************************/
/*! exports provided: HistoriaModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "HistoriaModule", function() { return HistoriaModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
/* harmony import */ var _historia_routing_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./historia-routing.module */ "./src/app/views/historia/historia-routing.module.ts");
/* harmony import */ var _ingreso_ingreso_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./ingreso/ingreso.component */ "./src/app/views/historia/ingreso/ingreso.component.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};





var HistoriaModule = /** @class */ (function () {
    function HistoriaModule() {
    }
    HistoriaModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [
                _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_4__["FormsModule"],
                _historia_routing_module__WEBPACK_IMPORTED_MODULE_2__["HistoriaRoutingModule"],
            ],
            declarations: [_ingreso_ingreso_component__WEBPACK_IMPORTED_MODULE_3__["IngresoComponent"]]
        })
    ], HistoriaModule);
    return HistoriaModule;
}());



/***/ }),

/***/ "./src/app/views/historia/historia.service.ts":
/*!****************************************************!*\
  !*** ./src/app/views/historia/historia.service.ts ***!
  \****************************************************/
/*! exports provided: HistoriaService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "HistoriaService", function() { return HistoriaService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _node_modules_angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../../../node_modules/@angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var HistoriaService = /** @class */ (function () {
    function HistoriaService(http) {
        this.http = http;
        this.httpOptions = {
            headers: new _node_modules_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpHeaders"]({
                'Access-Control-Allow-Origin': '*',
                'Content-Type': 'application/json',
                'Authorization': 'my-auth-token',
            })
        };
        this.url = 'http://127.0.0.1:8080/ingreso/createIngreso';
    }
    HistoriaService.prototype.crear = function (ingreso, token) {
        // this.httpOptions.headers = this.httpOptions.headers.append('Content-Type', ['application/json']);
        this.httpOptions.headers = this.httpOptions.headers.append('JSESSIONID', 'E03A88D6DD8E30B82523C08C21AE3367');
        console.log(this.httpOptions);
        return this.http.put(this.url, ingreso, {
            headers: new _node_modules_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpHeaders"]({
                'Access-Control-Allow-Origin': '*',
                'Content-Type': 'application/json',
                'Authorization': 'my-auth-token',
                'JSESSIONID': 'E03A88D6DD8E30B82523C08C21AE3367'
            })
        });
    };
    HistoriaService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [_node_modules_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]])
    ], HistoriaService);
    return HistoriaService;
}());



/***/ }),

/***/ "./src/app/views/historia/ingreso/ingreso.component.css":
/*!**************************************************************!*\
  !*** ./src/app/views/historia/ingreso/ingreso.component.css ***!
  \**************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/views/historia/ingreso/ingreso.component.html":
/*!***************************************************************!*\
  !*** ./src/app/views/historia/ingreso/ingreso.component.html ***!
  \***************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<p>\n  ingreso works!\n</p>\n\n<h3>Dar de alta a un paciente:</h3>\n<form class=\"container\">\n  <label for=\"motivoConsulta\">Motivo de consulta:</label>\n  <input name=\"motivoConsulta\" #inputUsername [(ngModel)]=\"ingreso.motivoConsulta\" type=\"text\" />\n  <label for=\"enfermedadActual\">Enfermedad actual:</label>\n  <input name=\"enfermedadActual\" [(ngModel)]=\"ingreso.enfermedadActual\" type=\"text\" />\n  <label>Diagnóstico presuntivo. </label>\n  <input name=\"diagnosticoPresuntivo\" [(ngModel)]=\"ingreso.diagnosticoPresuntivo\" type=\"text\" />\n  <label>Diagnóstico sintomatico. </label>\n\n  <input name=\"diagnosticoSindromatico\" [(ngModel)]=\"ingreso.diagnosticoSintomatico\" type=\"text\" />\n\n  <label>Diagnóstico sintomatico. </label>\n\n  <input name=\"diagnosticoSindromatico\" [(ngModel)]=\"ingreso.diagnosticoSintomatico\" type=\"text\" />\n\n  <label>Token: </label>\n\n  <input name=\"token\" [(ngModel)]=\"token\" type=\"text\" />\n  <button (click)='saveOperation()'>Crear usuario</button>\n</form>\n"

/***/ }),

/***/ "./src/app/views/historia/ingreso/ingreso.component.ts":
/*!*************************************************************!*\
  !*** ./src/app/views/historia/ingreso/ingreso.component.ts ***!
  \*************************************************************/
/*! exports provided: IngresoComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "IngresoComponent", function() { return IngresoComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _ingreso__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./ingreso */ "./src/app/views/historia/ingreso/ingreso.ts");
/* harmony import */ var _historia_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../historia.service */ "./src/app/views/historia/historia.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var IngresoComponent = /** @class */ (function () {
    function IngresoComponent(historiaService) {
        this.historiaService = historiaService;
        this.ingreso = new _ingreso__WEBPACK_IMPORTED_MODULE_1__["Ingreso"]();
    }
    IngresoComponent.prototype.ngOnInit = function () {
    };
    IngresoComponent.prototype.saveOperation = function () {
        this.historiaService.crear(this.ingreso, this.token).subscribe(function (result) {
            console.log(result);
            if (result.code !== 200) {
                console.log('Agregado');
            }
            else {
                console.log('Error');
            }
        }, function (error) {
            console.log(error);
        });
    };
    IngresoComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-ingreso',
            template: __webpack_require__(/*! ./ingreso.component.html */ "./src/app/views/historia/ingreso/ingreso.component.html"),
            styles: [__webpack_require__(/*! ./ingreso.component.css */ "./src/app/views/historia/ingreso/ingreso.component.css")]
        }),
        __metadata("design:paramtypes", [_historia_service__WEBPACK_IMPORTED_MODULE_2__["HistoriaService"]])
    ], IngresoComponent);
    return IngresoComponent;
}());



/***/ }),

/***/ "./src/app/views/historia/ingreso/ingreso.ts":
/*!***************************************************!*\
  !*** ./src/app/views/historia/ingreso/ingreso.ts ***!
  \***************************************************/
/*! exports provided: Ingreso */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Ingreso", function() { return Ingreso; });
var Ingreso = /** @class */ (function () {
    function Ingreso() {
        this.estudiosComplementarios = [];
        this.prescripciones = [];
    }
    return Ingreso;
}());



/***/ })

}]);
//# sourceMappingURL=views-historia-historia-module.js.map