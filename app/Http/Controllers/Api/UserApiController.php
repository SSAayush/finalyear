<?php

namespace App\Http\Controllers\Api;

use Illuminate\Http\Request;
use App\Http\Controllers\Api\BaseController;
use App\Models\User;
use Illuminate\Support\Facades\Auth;
use Validator;

class UserApiController extends BaseController{

    /**
     * Register api
     *
     * @return \Illuminate\Http\Response
     */

    public function register(Request $request)
    {
        $validator = Validator::make($request->all(), [
            'name' => 'required',
            'email' => 'required|email',
            'password' => 'required',
            // 'c_password' => 'required|same:password',
        ]);
   
        if($validator->fails()){
            return $this->sendError('Validation Error.', $validator->errors());       
        }

        $input = $request->all();
        $input['password'] = bcrypt($input['password']);
        $user = User::create($input);
        $success['token'] =  $user->createToken('MyApp')->plainTextToken;
        $success['name'] =  $user->name;
        return $this->sendResponse($success, 'User register successfully.');
    }

    /**
     * Login api
     *
     * @return \Illuminate\Http\Response
     */

    public function Login(Request $request){
        if(Auth::attempt(['email' => $request->email, 'password' => $request->password])){ 
            $user = Auth::user(); 
            $user['token'] =  $user->createToken('MyApp')->plainTextToken; 
            // $success['name'] =  $user->name;
   
            return $this->sendResponse($user, 'User login successfully.');
        }
        else{
        return $this->sendError('Unauthorised.', ['error'=>'Unauthorised']);
        }
    }

    // this api is for changing password
    public function changePassword(Request $request){
        $rules = [
            'id' => 'required',
            'password' => 'required',
        ];

        $input = $request->only('id','password');
        $validator = Validator::make($input,$rules);

        if($validator->fails()){
            return $this->sendError('Validation Error.', $validator->errors());       
        }

        $id = $request->id;
        $password = $request->password;

        $user = User::where('id','=',$id)->first();

        $input['password'] = bcrypt($input['password']);
        $user->password = bcrypt($password);
        $user->update();

        return $this->sendResponse($id, 'Password Changed Sucessfully');
    }

}
?>