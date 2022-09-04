@extends('orderdetails.layout.app')

 
@section('content')
    <div class="row">
        <div class="col-lg-11">
                <h2>Order Details</h2>
        </div>
        <div class="col-lg-1">
        <a class="btn btn-success" href="{{ route('orderdetails.create') }}">Add</a>
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
            <th>Order</th>
            <th>Food</th>
            <th>Quantity</th>
            <th width="280px">Action</th>
        </tr>
        @php
            $i = 0;
        @endphp
        @foreach ($orderdetails as $orderdetails)
            <tr>
                <td>{{ ++$i }}</td>
                <td>{{ $orderdetails->order_id }}</td>
                <td>{{ $orderdetails->foods_id }}</td>
                <td>{{ $orderdetails->quantity }}</td>
                <td>
                   
                </td>
            </tr>
        @endforeach
    </table>
@endsection