<html>
    <head><title>BurgerQuiz</title></head>
    <body>
        <h1>Questions BurgerQuiz</h1>
        <h2>Nuggets</h2>
        <form name="inscription" method="post" action="nuggets.php">
            Question : <input type="text" name="question"/> <br/>
            Reponse 1 : <input type="text" name="reponse1"/><input type="checkbox" name="repaccepte[]" value="r1"><br/>
			Reponse 2 : <input type="text" name="reponse2"/><input type="checkbox" name="repaccepte[]" value="r2"><br/>
			Reponse 3 : <input type="text" name="reponse3"/><input type="checkbox" name="repaccepte[]" value="r3"><br/>
			Reponse 4 : <input type="text" name="reponse4"/><input type="checkbox" name="repaccepte[]" value="r4"><br/>
            <input type="submit" name="valider" value="OK"/>
        </form>
		<?php
        if(isset($_POST['valider'])){
            $question=$_POST['question'];
            $reponse1=$_POST['reponse1'];
			$reponse2=$_POST['reponse2'];
			$reponse3=$_POST['reponse3'];
			$reponse4=$_POST['reponse4'];
			$today = date('H:i-d/m/y');
			$reponses = $_POST['repaccepte'];
			$arrayresponse = json_encode($reponses);
			
            echo 'Question: '. $question.'<br/>Reponse1'. $reponse1.'<br/>Reponse1'. $reponse2.'<br/>Reponse1'. $reponse3.'<br/>Reponse1'. $reponse4.'<br/>'.$arrayresponse.'  Je m\'occupe de ca !'. $today;
			
			
			$host="mysql51-109.perso";
			$username="remybaroperso";
			$password="kilose91";
			$db_name="remybaroperso";

			$con=mysql_connect("$host", "$username", "$password")or die("cannot connect"); 
			mysql_select_db("$db_name")or die("cannot select DB");
			$sql = 'INSERT INTO bq_nuggets_questions (question, date, author, commentaire, reponse1, reponse2, reponse3, reponse4, reponses) VALUES ("'. $question. '","'. $today. '", "Remy", "fromweb", "'.$reponse1.'","'.$reponse2.'", "'.$reponse3.'", "'.$reponse4.'", \''.$arrayresponse.'\')';
			echo $sql;
			$result = mysql_query($sql);
			mysql_close($con);
        }
        ?>
    </body>
</html>