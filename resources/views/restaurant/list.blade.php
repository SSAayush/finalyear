@extends('restaurant.layout.app')
<!-- @extends ('master') -->

@section('content')
    <div class="row">
        <div class="col-lg-11">
                <h2>Restaurant</h2>
        </div>
        <div class="col-lg-1">
        <a class="btn btn-success" href="{{ route('restaurant.create') }}">Add</a>
        </div>
    </div>
 
    @if ($message = Session::get('success'))
        <div class="alert alert-success">
            <p>{{ $message }}</p>
        </div>
    @endif
 
    <table class="table table-bordered">
        <tr>
            <th>No</th>
            <th>Name</th>
            <th>Address</th>
            <th>Contactno</th>
            <th>Delivery Time</th>
            <th>Min Order</th>
            <th>Opening Time</th>
            <th>Closing Time</th>
            <th>url</th>
            <th>Status</th>

            <th width="280px">Action</th>
        </tr>
        @php
            $i = 0;
        @endphp
        @foreach ($restaurant as $restaurant)
            <tr>
                <td>{{ ++$i }}</td>
                <td>{{ $restaurant->name }}</td>
                <td>{{ $restaurant->address }}</td>
                <td>{{ $restaurant->contactno }}</td>
                <td>{{ $restaurant->delivery_time }}</td>
                <td>{{ $restaurant->min_order }}</td>
                <td>{{ $restaurant->opening_time }}</td>
                <td>{{ $restaurant->closing_time }}</td>
                <td>{{ $restaurant->url }}</td>
                <td>{{ $restaurant->status }}</td>



                <td>
                    <form action="{{ route('restaurant.destroy',$restaurant->id) }}" method="POST">
                        <a class="btn btn-info" href="{{ route('restaurant.show',$restaurant->id) }}">Show</a>
                        <a class="btn btn-primary" href="{{ route('restaurant.edit',$restaurant->id) }}">Edit</a>
                        @csrf
                        @method('DELETE')
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </form>
                </td>
            </tr>
        @endforeach
    </table>
@endsection