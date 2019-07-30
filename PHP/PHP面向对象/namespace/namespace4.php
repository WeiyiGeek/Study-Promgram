<?php
/*
 *  多个命名空间
 */

	namespace hello\world {

		const AAA = "Hello world";
		class Demo {
			static function one() {
				echo "Hello function one() <br>";
			}
		}

		function test() {
			echo "Hello function test() <br>";
		}

		test();
		\hello\world\test();

		echo AAA."<br>";
		echo \hello\world\AAA."<br>";

		Demo::one();
		\hello\world\Demo::one();
	
	}

	namespace  meizi\pl {
	
		const BBB = "<hr>妹子";
		echo BBB."<br>";
		echo \meizi\pl\BBB."<br>";
		echo \hello\world\AAA."<br>";
	}

	namespace {
		\var_dump(100);
	}
	

