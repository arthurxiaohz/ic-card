package org.hi.common.util;

public class MoneyTransform {
	public static String getChnmoney(String strNum){
		 int n,m,k,i,j,q,p,r,s=0;
		 int length,subLength,pstn;
		 String change,output,subInput,input=strNum;
		        output="";
		    if(strNum.equals(""))
		       return null;
		    else
		     {
		 length=input.length();
		 pstn=input.indexOf('.'); //С�����λ��

		 if(pstn==-1)
		 {
		   subLength=length;//���С����ǰ������
		   subInput=input;
		 }
		        else
		  {
		   subLength=pstn;
		   subInput=input.substring(0,subLength);
		 }

		   char[] array=new char[4];
		   char[] array2={'Ǫ','��','ʰ'};
		   char[] array3={'��','��','Ԫ','��','��'};

		   n=subLength/4;//��ǧΪ��λ
		   m=subLength%4;

		   if(m!=0)
		   {
		     for(i=0;i<(4-m);i++)
		       {
		         subInput='0'+subInput;//������λ�����Ա㴦��
		       }
		            n=n+1;
		   }
		   k=n;

		   for(i=0;i<n;i++)
		   {
		     p=0;
		     change=subInput.substring(4*i,4*(i+1));
		     array=change.toCharArray();//ת�������鴦��

		     for(j=0;j<4;j++)
		     {
		                  output+=formatC(array[j]);//ת��������
		           if(j<3)
		           {
		                      output+=array2[j];//������λ����Ϊ���ǲ�����ǧ��ʮ��
		           }
		             p++;
		     }

		      if(p!=0)  output+=array3[3-k];//�������ƣ�����Ԫ�ֽǣ�
		    //�Ѷ������ȥ��

		             String[] str={"��Ǫ","���","��ʰ"};
		             for(s=0;s<3;s++)
		             {
		                while(true)
		                 {
		                  q=output.indexOf(str[s]);
		                  if(q!=-1)
		                  output=output.substring(0,q)+"��"+output.substring(q+str[s].length());
		                  else
		                   break;
		                  }
		             }
		             while(true)
		              {
		               q=output.indexOf("����");
		               if(q!=-1)
		                  output=output.substring(0,q)+"��"+output.substring(q+2);
		               else
		                   break;
		               }
		              String[] str1={"����","����","��Ԫ"};
		             for(s=0;s<3;s++)
		             {
		                while(true)
		                 {
		                  q=output.indexOf(str1[s]);
		                  if(q!=-1)
		                  output=output.substring(0,q)+output.substring(q+1);
		                  else
		                   break;
		                  }
		             }
		             k--;
		          }

		   if(pstn!=-1)//С�����ִ���
		   {
		      for(i=1;i<length-pstn;i++)
		     {
		              if(input.charAt(pstn+i)!='0')
		               {
		                output+=formatC(input.charAt(pstn+i));
		         output+=array3[2+i];
		                }
		              else if(i<2)
		                output+="��";
		              else
		                output+="";
		     }
		   }
		             if(output.substring(0,1).equals("��"))
		                  output=output.substring(1);
		             if(output.substring(output.length()-1,output.length()).equals("��"))
		                  output=output.substring(0,output.length()-1);
		          return output+="��";
		         }
		        }

		  public static String get3Eng(String strNum){
		 String strEng= "";
		 String str[] = {"","ONE","TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE"};
		 String str1[] = {"TEN","ELEVEN","TWELVE","THIRTEEN","FOURTEEN","FIFTEEN","SIXTEEN","SEVENTEEN","EIGHTEEN","NINETEEN"};
		 String str2[] = {"TEN","TWENTY","THIRTY","FORTY","FIFTY","SIXTY","SEVENTY","EIGHTY","NINETY","HUNDRED"};
		 int length = strNum.length();
		 int num = Integer.parseInt(strNum);
		 int b = num/100;
		 int t = (num%100)/10;
		 int g = (num%100)%10;
		 if (b!=0){
		  strEng = strEng + str[b] + " " + str2[9];
		 }

		 if (t==0){
		  if(g!=0){
		   if(b!=0){
		    strEng = strEng + " AND ";
		   }
		   strEng = strEng  + str[g];
		  }
		 }else if (t==1){
		   if(b!=0){
		    strEng = strEng + " AND ";
		                                num=num%100;
		   }
		  strEng = strEng  +str1[num-10];
		 }else if(t!=1){
		  if (g!=0){
		   if(b!=0){
		    strEng = strEng + " AND ";
		   }
		   strEng = strEng  + str2[t-1] + "-" + str[g];
		  }else{
		   if(b!=0){
		    strEng = strEng + " AND ";
		   }
		   strEng = strEng  + str2[t-1] + str[g];
		  }
		 }
		 return strEng;
		    }

		public static String getCent(String strNum){
		 String strEng= "";
		 String str[] = {"","ONE","TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE"};
		 String str1[] = {"TEN","ELEVEN","TWELVE","THIRTEEN","FOURTEEN","FIFTEEN","SIXTEEN","SEVENTEEN","EIGHTEEN","NINETEEN"};
		 String str2[] = {"TEN","TWENTY","THIRTY","FORTY","FIFTY","SIXTY","SEVENTY","EIGHTY","NINETY","HUNDRED"};
		 String str3[] = {"CENTS","","DOLLARS","","HUNDRED","THOUSAND","","","MILLION","","","BILLION","",""};
		    if(strNum.equals(""))
		       return null;
		    else
		      {
		        int length = strNum.length();
		 if (length!=3){
		  return "�����λ������";
		 }
		  int cent = Integer.parseInt(strNum.substring(1,3));
		  if (cent==0){
		   return strEng;
		  }
		  if (cent<10){
		   strEng =str3[0]+" "+ strEng + str[cent] ;
		  }else if (cent>=10&&cent<=19){
		   strEng =str3[0]+" "+ strEng + str1[cent-10] ;
		  }else if (cent>19){
		   int jiao = cent/10;
		   int fen = cent%10;
		   if (fen!=0){
		    strEng = str3[0]+" "+strEng + str2[jiao-1] + "-" +str[fen];
		   }else{
		    strEng = str3[0]+" "+strEng + str2[jiao-1] + str[fen];
		   }
		  }
		 return strEng;
		    }
		}
		public static String getEngmoney(String strNum) {
		 String strNumber="";
		 String str3[] = {"CENTS","","DOLLARS","","HUNDRED","THOUSAND","","","MILLION","","","BILLION","",""};
		 String strEng="";
		 strNumber = strNum;
		 int pointbz = strNumber.indexOf(".");
		 if (pointbz < 0){
		  strNumber = strNumber+".00";
		 }else if(pointbz > 0){
		  int k = strNum.length() - pointbz;
		  if(k==2){
		   strNumber = strNumber+"0";
		  }else if(k==1){
		   strNumber = strNumber+"00";
		  }
		 }
		 int length = strNumber.length();
		 if (length > 16){
		  return "�������ֵ����ϵͳ�޷�����";
		 }
		 String strb ="";
		 String strm ="";
		 String strq ="";
		 String stry ="";
		 String strf ="";
		 //�õ���
		 if(length==3){
		  strf = getCent(strNumber);
		  strEng = strEng + strf;
		 }else if(length>3&&length<7){
		  stry = get3Eng(strNumber.substring(0,length-3));
		  strf = getCent(strNumber.substring(length-3,length));
		  strEng = strEng + stry + " " + str3[2];
		  if (!strf.equals("")){
		   strEng = strEng + " AND " +strf;
		  }
		 }else if(length>6&&length<10){
		  strq = get3Eng(strNumber.substring(0,length-6));
		  stry = get3Eng(strNumber.substring(length-6,length-3));
		  strf = getCent(strNumber.substring(length-3,length));
		  strEng = strEng + strq + " " + str3[5];
		  if(stry.equals("")){
		   strEng = strEng + " " +stry;
		  }else{
		   strEng = strEng + " " +stry + " " + str3[2];
		  }
		  if(!strf.equals("")){
		   strEng = strEng + " AND " +strf;
		  }
		 }else if(length>9&&length<13){
		  strm = get3Eng(strNumber.substring(0,length-9));
		  strq = get3Eng(strNumber.substring(length-9,length-6));
		  stry = get3Eng(strNumber.substring(length-6,length-3));
		  strf = getCent(strNumber.substring(length-3,length));
		  strEng = strEng + strm + " " + str3[8];
		  if(!strq.equals("")){
		   strEng = strEng + " " + strq + " " + str3[5];
		  }
		  if(!stry.equals("")){
		   strEng = strEng + " " + stry + " " + str3[2];
		  }else{
		   strEng = strEng + " " + str3[2];
		  }
		  if(!strf.equals("")){
		   strEng = strEng + " AND " + strf;
		  }
		 }else if(length>12&&length<16){
		  strb = get3Eng(strNumber.substring(0,length-12));
		  strm = get3Eng(strNumber.substring(length-12,length-9));
		  strq = get3Eng(strNumber.substring(length-9,length-6));
		  stry = get3Eng(strNumber.substring(length-6,length-3));
		  strf = getCent(strNumber.substring(length-3,length));
		  strEng = strEng + strb + " " + str3[11];
		  if(!strm.equals("")){
		   strEng = strEng + " " + strm + " " + str3[8];
		  }
		  if(!strq.equals("")){
		   strEng = strEng + " " + strq + " " + str3[5];
		  }
		  if(!stry.equals("")){
		   strEng = strEng + " " + stry + " " + str3[2];
		  }else{
		   strEng = strEng + " " + str3[2];
		  }
		  if(!strf.equals("")){
		   strEng = strEng + " AND " + strf;
		  }
		 }

		 return strEng+" ONLY";
		}

		  public static String formatC(char x)
		  {
		    String a="";
		    switch(x)
		    {
		      case'0':  a="��";
		                break;
		      case'1':  a="Ҽ";
		                break;
		      case'2':  a="��";
		                break;
		      case'3':  a="��";
		                break;
		      case'4':  a="��";
		                break;
		      case'5': a="��";
		                break;
		      case'6':  a="½";
		                break;
		      case'7':  a="��";
		                break;
		      case'8':  a="��";
		                break;
		      case'9':  a="��";
		                break;
		    }
		    return a;
		  }




	public static void main(String[] args) {
		System.out.println(MoneyTransform.getChnmoney("20088000"));
	}
}
