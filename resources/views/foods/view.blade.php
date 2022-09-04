@extends('foods.layouts.app')
 
@section('content')
    <div class="row">
        <div class="col-lg-11">
                <h2>Show Foods</h2>
        </div>
        <div class="col-lg-1">
            <a class="btn btn-primary" href="{{ url('foods') }}"> Back</a>
        </div>
    </div>
    <table class="table table-bordered">
        <tr>
            <th>Name:</th>
            <td>{{ $food->name }}</td>
        </tr>

        <tr>
            <th>Price:</th>
            <td>{{ $food->price }}</td>
        </tr>

        <tr>
            <th>Category:</th>
            <td>{{ $food->categories_id }}</td>
        </tr>

        <tr>
            <th>Restaurant:</th>
            <td>{{ $food->restaurant_id }}</td>
        </tr>


        <tr>
            <th>Status:</th>
            <td>{{ $food->status }}</td>
        </tr>
 
    </table>
@endsection