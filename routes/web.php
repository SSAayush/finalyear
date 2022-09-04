<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\StudentController;
use App\Http\Controllers\CategoryController;
use App\Http\Controllers\UploadController;
use App\Http\Controllers\OrderController;


/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function () {
    return view('welcome');
});


Route::get('/hello', function () {
    return view('home');
});

Route::resource('student','StudentController');

Route::resource('category', CategoryController::class);

Route::resource('restaurant','RestaurantController');

Route::resource('foods','FoodsController');

Route::resource('order','OrderController');

Route::resource('orderdetails','OrderDetailsController');

Route::resource('payment','PaymentController');






Route::view('admin', 'master');




Route::resource('upload','UploadController');
// Route::resources('category','CategoryController');

// Route::group([], function () {
//     Route::get('category', 'CategoryController@index')->name('home');
//  });



Auth::routes();

Route::get('/home', [App\Http\Controllers\HomeController::class, 'index'])->name('home');

Route::delete('/foods-delete/{id}', 'Admin\FoodsController@delete');
