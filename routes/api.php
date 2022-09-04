<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\Api\UserApiController;
use App\Http\Controllers\Api\CategoryApiController;
use App\Http\Controllers\Api\RestaurantApiController;
use App\Http\Controllers\Api\FoodApiController;
use App\Http\Controllers\Api\OrderApiController;
use App\Http\Controllers\Api\OrderDetailsApiController;



/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
    return $request->user();
});

// Route::apiResource('category','Api\CategoryApiController');
Route::apiResource('restaurant','Api\RestaurantApiController');
Route::apiResource('food','Api\FoodApiController');

Route::controller(CategoryApiController::class)->group(function(){
    Route::post('category', 'index');
    
});

Route::controller(UserApiController::class)->group(function(){
    Route::post('register', 'register');
    Route::post('login', 'login');
    Route::post('changePassword', 'changePassword');
    
});

Route::controller(OrderApiController::class)->group(function(){
    Route::post('order', 'order');
    
});

// Route::get("search/{name}",[OrderDetailsApiController::class,'search']);

Route::controller(OrderDetailsApiController::class)->group(function(){
    Route::post('search', 'search');
    
});



