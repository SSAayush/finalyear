<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

use Spatie\MediaLibrary\HasMedia;
use Spatie\MediaLibrary\InteractsWithMedia;
use Spatie\MediaLibrary\MediaCollections\Models\Media;

class Restaurant extends Model implements HasMedia
{
    public $table = 'restaurant' ;
    use HasFactory;
    protected $fillable = [
        'name',
        'address',
        'contactno',
        'delivery_time',
        'min_order',
        'opening_time',
        'closing_time',
        'url',
        'status',      
    ];

    use InteractsWithMedia;

    public static function last()
    {
        return static::all()->last();
    }

    // public function registerMediaConversions(Media $media = null): void
    // {
    //     $this
    //         ->addMediaConversion('thumb')
    //         ->width(300)
    //         ->height(300);
    // }
}
