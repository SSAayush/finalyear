<?php

namespace App\Http\Controllers;

use App\Models\Food;
use App\Models\Category;
use App\Models\Restaurant;
use Illuminate\Http\Request;


class FoodsController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        //
        $foods = Food::all();
        // return CategoryResource::collection($category);
        return view('foods.list',compact('foods','foods'));
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        //
        return view('foods.create', [
            'categories' => Category::all(),
            'restaurant' => Restaurant::all()
        ]);
        // return view('foods.create');
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        // var_dump($request->get('category_id'));exit();
        //
        $request->validate([
            'txtName'=>'required',
            'txtPrice'=>'required',
            // 'txtCategory'=>'required',
            // 'txtRestaurant'=>'required',
            'txturl'=>'required',
            'txtStatus'=> 'required',
        ]);

        // Required Fields
        // 'name',
        // 'price',
        // 'categories_id',
        // 'restaurant_id',
        // 'status',  
 
        $foods = new Food([
            'name' => $request->get('txtName'),
            'price' => $request->get('txtPrice'),
            'categories_id' => $request->get('txtCategory'),
            'restaurant_id' => $request->get('txtRestaurant'),
            'url'=> $request->get('txturl'),
            'status'=> $request->get('txtStatus')
        ]);

        // var_dump($foods->category_id);exit();
 
        $foods->save();
        return redirect('/foods')->with('success', 'foods has been added');  
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Models\Food  $foods
     * @return \Illuminate\Http\Response
     */
    public function show(Food $food)
    {

            // return view('foods.view', [
            //     'foods' => Food::findOrFail($food)
            // ]);
        return view('foods.view',compact('food','food'));
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Models\Food  $foods
     * @return \Illuminate\Http\Response
     */
    public function edit(Food $food)
    {
        //
    //    var_dump($foods->price);
    //    exit();
        // return view('foods.edit',compact('food','food'));
        $restaurant = Restaurant::all();
        $data = [
            'restaurant'  => $restaurant,
            'food' => $food
        ];
        
        
        return view('foods.edit',$data);
        // return CategoryResource::collection($category);
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\Food  $foods
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        //
        $request->validate([
            'txtName'=>'required',
            'txtPrice'=>'required',
            // 'txtCategory'=>'required',
            // 'txtRestaurant'=>'required',
            'txturl'=>'required',
            'txtStatus'=> 'required'
        ]);
 
        // var_dump($request->get('txtRestaurant'));
        // exit();
        $foods = Food::find($id);
        $foods->name = $request->get('txtName');
        $foods->price = $request->get('txtPrice');
        $foods->categories_id = $request->get('txtCategory');
        $foods->restaurant_id = $request->get('txtRestaurant');
        $foods->status = $request->get('txturl');
        $foods->status = $request->get('txtStatus');
 
        $foods->update();
 
        return redirect('/foods')->with('success', 'Foods updated successfully');
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\Food  $foods
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        //
        $destory = Food::where('id', $id)->delete();

        
        // $foods->delete();
        return redirect('/foods')->with('success', 'Food deleted successfully');
      
    }
}
