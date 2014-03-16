function checkstr(str)
{

if(str>=48&&str<=57)//Êı×Ö
{
return 1;
}
else if(str>=65&&str<=90)//´óĞ´×ÖÄ¸
{
return 2;
}
else if(str>=97&&str<=122)//Ğ¡Ğ´×ÖÄ¸
{
return 3;
}
else//ÌØÊâ×Ö·û
{
return 4;
}
}
function checkl(string)
{
n=false;
s=false;
t=false;
l_num=0;
if(string.length<6)
{
l_num=1;
}
else
{
for(i=0;i<string.length;i++)
{
   asc=checkstr(string.charCodeAt(i));
   if(asc==1&&n==false){l_num+=1;n=true;}
   if((asc==2||asc==3)&&s==false){l_num+=1;s=true;}
   if(asc==4&&t==false){l_num+=1;t=true;}
}
}
return l_num;
}

function checklevel(psw)
{
color="#ededed";
color_l="#ff0000";
color_m="#ff9900";
color_h="#33cc00";
if(psw==null||psw=='')
{
lcor=color;
mcor=color;
hcor=color;
}
else
{
thelev=checkl(psw)
switch(thelev)
{
   case 1:
   lcor=color_l;
   hcor=mcor=color;
   break;
   case 2:
   mcor=lcor=color_m;
   hcor=color;
   break;
   case 3:
   hcor=mcor=lcor=color_h;
   break;
   default:
   lcor=mcor=hcor=color;
}
}
document.getElementById("strength_L").style.background=lcor;
document.getElementById("strength_M").style.background=mcor;
document.getElementById("strength_H").style.background=hcor;
}