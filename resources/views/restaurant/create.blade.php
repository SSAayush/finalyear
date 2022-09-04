<!-- @extends('restaurant.layout.app') -->
 
@section('content')
    <div class="row">
        <div class="col-lg-11">
            <h2>Add New Restaurnat </h2>
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
    <form action="{{ route('restaurant.store') }}" method="POST" enctype="multipart/form-data">
        @csrf
        <div class="form-group">
            <label for="Name">Name:</label>
            <input type="text" class="form-control" id="txtName" placeholder="Enter restaurant Name " name="txtName">
        </div>

        <!-- <div class="form-group">
            <label for="image">Image Upload :</label>
            <input class="form-control" type="file" name="image">
        </div> -->

        <div class="form-group">
            <label for="Address">Address:</label>
            <input type="text" class="form-control" id="txtAddress" placeholder="Enter Address" name="txtAddress">
        </div>

        <div class="form-group">
            <label for="txtContactno">Contactno:</label>
            <input type="text" class="form-control" id="txtContactno" placeholder="Enter Contactno" name="txtContactno">
        </div>
        
        <div class="form-group">
            <label for="txtDelivery_time">Delivery Time:</label>
            <input type="text" class="form-control" id="txtDelivery_time" placeholder="Enter delivery time" name="txtDelivery_time">
        </div>

        <div class="form-group">
            <label for="txtmin_order">Min Order:</label>
            <input type="text" class="form-control" id="txtmin_order" placeholder="Enter min order" name="txtmin_order">
        </div>

        <div class="form-group">
            <label for="txtopening_time">Opening Time:</label>
            <input type="text" class="form-control" id="txtopening_time" placeholder="Enter opening time" name="txtopening_time">
        </div>

        <div class="form-group">
            <label for="txtclosing_time">Closing Time:</label>
            <input type="text" class="form-control" id="txtclosing_time" placeholder="Enter closing time" name="txtclosing_time">
        </div>

        <div class="form-group">
            <label for="txturl">url:</label>
            <input type="text" class="form-control" id="txturl" placeholder="Enter url" name="txturl">
        </div>

        <div class="form-group">
            <label for="txtLastName">Status:</label>
            <input type="text" class="form-control" id="txtStatus" placeholder="Enter Status" name="txtStatus">
        </div>
        
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
@endsection