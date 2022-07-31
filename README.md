# reimbursement_app
Webapp that calculate reimbursement

##Preparation
######You need to:
1.Import project to Eclipse IDE for Java EE Developers
2.Window > Show view > Servers
3.In tabs of lower menu choose "Servers"
4.Click link to add new server.
5.Choose Apache> Tomcat v8.5 and click "next"
6.From list of available project choose newly uploaded one and click add and finish
7.Right click project in left panel, Run as > Run on server> choose server and click finish
8.Import included data to MySQL database of your choosing. Run database. Needed port is 3306.

##Use

######A) User

1. Log in with your login (user123) and password(123)
2. Click "Add new reimbursement claim"

3. Add receipts by choosing type of receipts from dropdown and adding amount spend.
4. Click "Add receipt" to add receipt (duh)
5. New receipt should be shown in table below.
6. Click "Stage 2"

7.Fill out the form and click save
8.You should be presented with summary of all expenses with option to go back.
Also data is saved in database.

######B) Administrator

1. Log in with your login (admin123) and password(123)
2. In configuration panel you can change numbers perferable ones. After doing so click "Reconfigure"
3. If you want to edit receipt types, click button with that name.
4. In Edit Receipts panel, you can manage list of receipt types by deleting them or adding new one 
