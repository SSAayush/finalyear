<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Restaurant;
use App\Http\Resources\RestaurantResource;


class RestaurantController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        //
        $restaurant = Restaurant::all();
        // return CategoryResource::collection($category);
        return view('restaurant.list',compact('restaurant','restaurant'));
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        //
        
         return view('restaurant.create');
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        //
        $request->validate([
            'txtName'=>'required',
            'txtAddress' => 'required',
            'txtContactno'=> 'required',
            'txtDelivery_time'=>'required',
            'txtmin_order'=>'required',
            'txtopening_time'=>'required',
            'txtclosing_time'=>'required',
            'txturl'=>'required',
            'txtStatus'=> 'required',
        ]);
        

        $restaurant = new Restaurant([
            'name' => $request->get('txtName'),
            'address'=> $request->get('txtAddress'),
            'contactno'=> $request->get('txtContactno'),
            'delivery_time'=> $request->get('txtDelivery_time'),
            'min_order'=> $request->get('txtmin_order'),
            'opening_time'=> $request->get('txtopening_time'),
            'closing_time'=> $request->get('txtclosing_time'),
            'url'=> $request->get('txturl'),
            'status'=> $request->get('txtStatus'),

        ]);

        // $restaurant
        //     ->addMediaFromRequest('image')
        //     ->toMediaCollection();
 
        
            $restaurant->save();
            return redirect('/restaurant')->with('success', 'Restaurant has been added');
        // }else{
        //     return redirect('/restaurant')->with('error', 'Error adding restaurant');
        // }
       
    }


    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show(Restaurant $restaurant)
    {
        //
        // var_dump($restaurant->delivery_time);
        // exit();
        return view('restaurant.view',compact('restaurant'));
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit(Restaurant $restaurant)
    {
        //
        // var_dump($restaurant->min_order);
        // exit();
        return view('restaurant.edit',compact('restaurant'));
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, Restaurant $restaurant)
    {
        //
        $request->validate([
            'txtName'=>'required',
            'txtAddress' => 'required',
            'txtContactno'=> 'required',
            'txtdelivery_time'=>'required',
            'txtmin_order'=>'required',
            'txtopening_time'=>'required',
            'txtclosing_time'=>'required',
            'txturl'=>'required',
            'txtStatus'=> 'required'
        ]);
 
        $restaurant = new Restaurant([
            'name' => $request->get('txtName'),
            'address'=> $request->get('txtAddress'),
            'contactno'=> $request->get('txtContactno'),
            'delivery_time'=> $request->get('txtdelivery_time'),
            'min_order'=> $request->get('txtmin_order'),
            'opening_time'=> $request->get('txtopening_time'),
            'closing_time'=> $request->get('txtclosing_time'),
            'url'=> $request->get('txturl'),
            'status'=> $request->get('txtStatus'),
           
        ]);
 
        $restaurant->save();
        return redirect('/restaurant')->with('success', 'Restaurant has been added');

    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy(Restaurant $restaurant)
    {
        //
        $restaurant->delete();
        return redirect('/restaurant')->with('success', 'Restaurant deleted successfully');
    }
}
