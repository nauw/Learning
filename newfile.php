<?php


Class MyTest
{

    /*
     * @return null
     */
    public function Test()
    {
        echo 'this is my test';
        echo 'to be merged';
        $this->HiddenMethod();
    }


    private function HiddenMethod(){
        return true;
    }

}
