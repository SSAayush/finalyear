@extends('restaurant.layout.app')
 
@section('content')
    <div class="row">
        <div class="col-lg-11">
                <h2>Show Restaurant</h2>
        </div>
        <div class="col-lg-1">
            <a class="btn btn-primary" href="{{ url('restaurant') }}"> Back</a>
        </div>
    </div>
    <table class="table table-bordered">
        <tr>
            <th>Name:</th>
            <td>{{ $restaurant->name }}</td>
        </tr>

        <tr>
            <th>Address:</th>
            <td>{{ $restaurant->address }}</td>
        </tr>

        <tr>
            <th>Contactno:</th>
            <td>{{ $restaurant->contactno }}</td>
        </tr>

        <tr>
            <th>Status:</th>
            <td>{{ $restaurant->status }}</td>
        </tr>

        <tr>
            <th>Delivery Time:</th>
            <td>{{ $restaurant->DeliveryTime }}</td>
        </tr>

        <tr>
            <th>Min Order:</th>
            <td>{{ $restaurant->MinOrder }}</td>
        </tr>

        <tr>
            <th>Opening Time:</th>
            <td>{{ $restaurant->OpeningTime }}</td>
        </tr>

        <tr>
            <th>Closing Time:</th>
            <td>{{ $restaurant->ClosingTime }}</td>
        </tr>

        <tr>
            <th>Image:</th>
            <td>{{ $restaurant->Image }}</td>
        </tr>
 
    </table>
@endsection