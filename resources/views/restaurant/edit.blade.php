@extends('restaurant.layout.app')
@extends ('master')
 
@section('content')
    <div class="row">
        <div class="col-lg-11">
            <h2>Update Restaurant</h2>
        </div>
        <div class="col-lg-1">
            <a class="btn btn-primary" href="{{ url('restaurant') }}"> Back</a>
        </div>
    </div>
 
    @if ($errors->any())
        <div class="alert alert-danger">
            <strong>Whoops!</strong> There were some problems with your input.<br><br>
            <ul>
                @foreach ($errors->all() as $error)
                    <li>{{ $error }}</li>
                @endforeach
            </ul>
        </div>
    @endif
    <form method="post" action="{{ route('restaurant.update',$restaurant->id) }}" >
        @method('PATCH')
        @csrf
        <div class="form-group">
            <label for="txtName"> Name:</label>
            <input type="text" class="form-control" id="txtName" placeholder="Enter Name" name="txtName" value="{{ $restaurant->name }}">
        </div>

        <div class="form-group">
            <label for="txtAddress">Address:</label>
            <textarea class="form-control" id="txtAddress" name="txtAddress" rows="10" placeholder="Enter Address">{{ $restaurant->address }}</textarea>
        </div>

        <div class="form-group">
            <label for="txtCOntactno">Contactno:</label>
            <input type="text" class="form-control" id="txtContactno" placeholder="Enter Contactno" name="txtContactno" value="{{ $restaurant->contactno }}">
        </div>
   

        <div class="form-group">
            <label for="txtdelivery_time">Delivery Time:</label>
            <input type="text" class="form-control" id="txtdelivery_time" placeholder="Enter delivery time" name="txtDelivery_time" value="{{ $restaurant->delivery_time }}">
        </div>

        <div class="form-group">
            <label for="txtmin_order">Min Order:</label>
            <input type="text" class="form-control" id="txtmin_order" placeholder="Enter min order" name="txtMin_order" value="{{ $restaurant->min_order }}">
        </div>

        <div class="form-group">
            <label for="txtopening_time">Opening Time:</label>
            <input type="text" class="form-control" id="txtopening_time" placeholder="Enter opening time" name="txtOpening_time"  value="{{ $restaurant->opening_time }}">
        </div>

        <div class="form-group">
            <label for="txtclosing_time">Closing Time:</label>
            <input type="text" class="form-control" id="txtclosing_time" placeholder="Enter closing time" name="txtClosing_time"  value="{{ $restaurant->closing_time }}">
        </div>

        <div class="form-group">
            <label for="txtLastName">Status:</label>
            <input type="text" class="form-control" id="txtStatus" placeholder="Enter Status" name="txtStatus" value="{{ $restaurant->status }}">
        </div>
   
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
@endsection