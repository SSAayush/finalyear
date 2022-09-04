<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class OrderDetails extends Model
{
    public $table = 'order_details' ;
    use HasFactory;
    protected $fillable = [
        'order_id',
        'foods_id', 
        'quantity',     
    ];
}
