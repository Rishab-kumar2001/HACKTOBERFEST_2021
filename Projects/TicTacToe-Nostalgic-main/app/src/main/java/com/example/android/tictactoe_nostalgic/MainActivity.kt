package com.example.android.tictactoe_nostalgic
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var myBluetoothAdapter : BluetoothAdapter
    lateinit var btEnablingIntent : Intent
    var RequestCodeForEnable : Int = 0
    var turn : Int=1
    var game   = arrayOf(25,24,23,22,21,20,19,18,17)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        myBluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
        btEnablingIntent=Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
        RequestCodeForEnable=1
        bluetoothONMethod()


        reset.setOnClickListener{
            turn =1
            game   = arrayOf(25,24,23,22,21,20,19,18,17)
            finish()

            myBluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
            btEnablingIntent=Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            RequestCodeForEnable=1
            bluetoothONMethod()
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        imageView1.setOnClickListener(this)
        imageView2.setOnClickListener(this)
        imageView3.setOnClickListener(this)
        imageView4.setOnClickListener(this)
        imageView5.setOnClickListener(this)
        imageView6.setOnClickListener(this)
        imageView7.setOnClickListener(this)
        imageView8.setOnClickListener(this)
        imageView9.setOnClickListener(this)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==RequestCodeForEnable){
            if(resultCode== RESULT_OK){
                Toast.makeText(applicationContext,"Bluetooth Is Enabled",Toast.LENGTH_SHORT).show()
            }else if (resultCode== RESULT_CANCELED){
                Toast.makeText(applicationContext,"Bluetooth  Enabling Canceled",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun bluetoothONMethod() {
        if(myBluetoothAdapter==null){
            Toast.makeText(applicationContext,"Bluetooth does not support this device",Toast.LENGTH_SHORT).show()
        }else{
            if(!myBluetoothAdapter.isEnabled){
                startActivityForResult(btEnablingIntent,RequestCodeForEnable)
            }
        }
    }


    override fun onClick(v: View?) {
        if(turn%2==0){
            v?.setBackgroundResource(R.drawable.x)
            textView1.text="Play Player I"

            chance(v?.id)
            v?.isClickable=false
            turn++
        }else{
            v?.setBackgroundResource(R.drawable.o)
            textView1.text="Play Player II"
            chance(v?.id)
            v?.isClickable=false
            turn++
        }
    }

    private fun chance(id: Int?) {
        var btnno : Int? = (id?.rem(100))?.minus(34)
        if(turn%2 == 0){
            game[btnno!!]=1
        }else{
            game[btnno!!]=2
        }
        check()
    }

    private fun check() {
        if(game[0] == game [1] && game[1]==game[2]){
            displayIt()
        }else if(game[3] == game [4] && game[4]==game[5]){
            displayIt()
        }else if(game[6] == game [7] && game[7]==game[8]){
            displayIt()
        }else if(game[0] == game [3] && game[3]==game[6]){
            displayIt()
        }else if(game[1] == game [4] && game[4]==game[7]){
            displayIt()
        }else if(game[2] == game [5] && game[5]==game[8]){
            displayIt()
        }else if(game[0] == game [4] && game[4]==game[8]){
            displayIt()
        }else if(game[2] == game [4] && game[4]==game[6]){
            displayIt()
        }
    }

    private fun displayIt() {
        if(turn%2==0){
            textView1.text="Player II Wins"
            disable()
        }else{
            textView1.text="Player I Wins"
            disable()
        }
    }

    private fun disable() {
        imageView1.isClickable = false
        imageView2.isClickable = false
        imageView3.isClickable = false
        imageView4.isClickable = false
        imageView5.isClickable = false
        imageView6.isClickable = false
        imageView7.isClickable = false
        imageView8.isClickable = false
        imageView9.isClickable = false
    }


}