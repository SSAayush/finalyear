@extends('order.layout.app')


@section('content')
    <div class="row">
        <div class="col-lg-11">
                <h2>Order</h2>
        </div>
        <div class="col-lg-1">
        <a class="btn btn-success" href="{{ route('order.create') }}">Add</a>
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
            <th>User</th>
            <th>Restaurant</th>
            <th>Address</th> 
            <th>Total</th> 
            <th width="280px">Action</th>
        </tr>
        @php
            $i = 0;
        @endphp
        @foreach ($order as $order)
            <tr>
                <td>{{ ++$i }}</td>
                <td>{{ $order->user_id }}</td>
                <td>{{ $order->restaurant_id }}</td>
                <td>{{ $order->address_details }}</td>
                <td>{{ $order->total }}</td>
                <td>
                   
                </td>
            </tr>
        @endforeach
    </table>
@endsection