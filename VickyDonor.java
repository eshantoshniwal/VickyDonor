import java.util.Scanner;
class VickyDonor
{
    String name[]=new String[1000], dob[]=new String[1000], 
    email[]=new String[1000], address[]=new String[1000], phone[]=new String[1000], 
    don[]=new String[1000];
    int h, i=0, c, ch, j, d, gender[]=new int[1000], bloodGroup[]=new int[1000],
    hospital[]=new int[1000], prevDonate[]=new int[1000], passcode=1234, pass, bg;
    boolean bloodCollected[]=new boolean[1000], check;

    public void emailInput()
    {
        Scanner sc = new Scanner(System.in);
        boolean check=true;
        do{
            String buffering;
            int k, indexOfAt, lastIndexOfAt, countOfAt=0, len, countOfDotAfterAt = 0;
            char chr;
            boolean checkEndDot=false;
            check=true;

            System.out.print("Enter email: ");
            email[i] = sc.nextLine();

            checkEndDot = email[i].endsWith(".");
            indexOfAt = email[i].indexOf('@');
            lastIndexOfAt = email[i].lastIndexOf('.');
            for (k = 0; k < email[i].length(); k++)
                if(email[i].charAt(k)=='@')
                    countOfAt++;

            buffering = email[i].substring(email[i].indexOf('@')+1, email[i].length());
            len = buffering.length();

            for (k=0; k<len; k++)
                if(buffering.charAt(k)=='.')
                    countOfDotAfterAt++;

            if ((countOfAt==1) && (email[i].charAt(email[i].indexOf('@')-1)!='.')  && (countOfDotAfterAt ==1) &&   
            ((indexOfAt+3) <= (lastIndexOfAt) && !checkEndDot))
                check=true;

            else
            {
                System.out.println("\nInvalid email address! Try Again!\n\n");
                check=false;
            }
        }while(check==false);
    }

    public void donInput()
    {
        int days[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        boolean check=true;
        Scanner sc = new Scanner(System.in);
        do{
            String date, day, dig="";
            int k, dd=0, mm=0, yy=0, n, cnt=0;
            char chr, del='/';
            check=true;

            System.out.print("Enter date of most recent donation in mm/dd/yyyy format: ");
            don[i] = sc.nextLine();

            n = don[i].length();  
            for(k=0; k<n; k++)
            {
                chr = don[i].charAt(k);
                dig += Character.isDigit(chr) ? chr : "";
                if(!Character.isDigit(chr) || k==n-1)
                {
                    if((chr=='.' || chr=='-' || chr=='/') && cnt==0)
                        del = chr;
                    if(chr==del || k==n-1)
                        cnt++;
                    else
                    {
                        System.out.println("\nError! Invalid character found in the date string! Try Again!");
                        check=false;
                        break;
                    }
                    if(cnt==1)
                        mm = Integer.parseInt(dig);
                    else if(cnt==2)
                        dd = Integer.parseInt(dig);
                    else if(cnt==3)
                        yy = Integer.parseInt(dig);
                    else
                    {
                        System.out.println("\nError! Invalid date entered! Try Again!");
                        check=false;
                        break;
                    }
                    dig = "";
                }
            }

            days[2] = yy%400==0 || yy%4==0 && yy%100!=0 ? 29 : 28;
            if(!(yy>=1000 && yy<=9999 && mm>=1 && mm<=12 && dd>=1 && dd<=days[mm]))
            {
                System.out.println("\nError! Invalid date inputted! Try Again!");
                check=false;
            }
        }while(check==false);
    }

    public void dobInput()
    {
        int days[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        boolean check=true;
        Scanner sc = new Scanner(System.in);
        do{
            String date, day, dig="";
            int k, dd=0, mm=0, yy=0, n, cnt=0;
            char chr, del='/';
            check=true;

            System.out.print("Enter date of birth in mm/dd/yyyy format: ");
            dob[i] = sc.nextLine();

            n = dob[i].length();  
            for(k=0; k<n; k++)
            {
                chr = dob[i].charAt(k);
                dig += Character.isDigit(chr) ? chr : "";
                if(!Character.isDigit(chr) || k==n-1)
                {
                    if((chr=='.' || chr=='-' || chr=='/') && cnt==0)
                        del = chr;
                    if(chr==del || k==n-1)
                        cnt++;
                    else
                    {
                        System.out.println("\nError! Invalid character found in the date string! Try Again!");
                        check=false;
                        break;
                    }
                    if(cnt==1)
                        mm = Integer.parseInt(dig);
                    else if(cnt==2)
                        dd = Integer.parseInt(dig);
                    else if(cnt==3)
                        yy = Integer.parseInt(dig);
                    else
                    {
                        System.out.println("\nError! Invalid date entered! Try Again!");
                        check=false;
                        break;
                    }
                    dig = "";
                }
            }

            days[2] = yy%400==0 || yy%4==0 && yy%100!=0 ? 29 : 28;
            if(!(yy>=1000 && yy<=9999 && mm>=1 && mm<=12 && dd>=1 && dd<=days[mm]))
            {
                System.out.println("\nError! Invalid date inputted! Try Again!");
                check=false;
            }
        }while(check==false);
    }

    public void main()
    {
        Scanner sc = new Scanner(System.in);

        do
        {
            System.out.print("\f\tDONOR FUNCTION OPTIONS:-"+
                "\n1. Create Donor Account\n2. Use Hospital Account\n3. Exit program"+
                "\n\nEnter choice (1-3): ");
            ch = sc.nextInt();

            switch(ch)
            {
                case 1:
                System.out.print("\nEnter name of donor: ");
                sc.nextLine(); name[i] = sc.nextLine();
                dobInput();
                do
                {
                    System.out.print("Enter gender[(1) Male (2) Female (3) Other]: ");
                    gender[i] = sc.nextInt();
                } while(gender[i]!=1 && gender[i]!=2 && gender[i]!=3);
                System.out.print("Enter address: ");
                sc.nextLine();address[i] = sc.nextLine();
                do
                {
                    System.out.print("Enter phone number without country code: ");
                    phone[i] = sc.nextLine();
                } while(phone[i].length()!=10);
                emailInput();
                do
                {
                    System.out.print("Enter Blood Group[(1) A+ (2) A- (3) B+ (4) B- (5) O+ "+
                        "(6) O- (7) AB+ (8) AB- (9) Do not know]: ");
                    bloodGroup[i] = sc.nextInt();
                } while(bloodGroup[i]!=1 && bloodGroup[i]!=2 && bloodGroup[i]!=3 && 
                bloodGroup[i]!=4 && bloodGroup[i]!=5 && bloodGroup[i]!=6 && bloodGroup[i]!=7 && 
                bloodGroup[i]!=8 && bloodGroup[i]!=9);
                do
                {
                    System.out.print("Enter choice of hospital(1, 2, 3, 4 or 5): ");
                    hospital[i] = sc.nextInt();
                } while(hospital[i]!=1 && hospital[i]!=2 && hospital[i]!=3 && 
                hospital[i]!=4 && hospital[i]!=5);
                do
                {
                    System.out.print("\nEnter (1) if you have donated blood before or (0) if you have "+
                        "never donated blood before: ");
                    prevDonate[i] = sc.nextInt();
                } while(prevDonate[i]!=0 && prevDonate[i]!=1);
                if(prevDonate[i]==1)
                    donInput();
                bloodCollected[i]=false;
                i++;
                System.out.println("\nNew Request for donation has been successfully created. Hospital will contact you shortly.");
                break;

                case 2:
                System.out.print("\nEnter hospital password to check records: ");
                pass = sc.nextInt();
                if(pass==passcode)
                {
                    do
                    {
                        System.out.print("\n\nHOSPITAL MODE OPTIONS:-\n1. See Donor List (Hospital-wise)\n"+
                            "2. See Donor List (Blood Group-wise)\n3. Exit"+
                            "\n\nEnter choice (1-3): ");
                        c = sc.nextInt();
                        switch(c)
                        {
                            case 1:
                            check = false;
                            do
                            {
                                System.out.print("\nEnter hospital number (1, 2, 3, 4 or 5): ");
                                h = sc.nextInt();
                            } while(h!=1 && h!=2 && h!=3 && h!=4 && h!=5);
                            System.out.println("\nDONOR ID\tNAME\t\t\tDOB\t\tGENDER\tPHONE\t\tEMAIL\t\t\t\tBLOOD GROUP\tPREVIOUS DONATION");
                            for(j=0; j<=i; j++)
                            {
                                if(hospital[j]==h && !bloodCollected[j])
                                {
                                    System.out.print((j+1)+"\t\t"+name[j]+"\t\t"+dob[j]+"\t"+(gender[j]==1 ? "Male\t" : gender[j]==1 ? "Female\t" : "Other\t")+
                                        phone[j]+"\t"+email[j]+"\t\t\t");
                                    System.out.print(bloodGroup[j]==1 ? "A+" : bloodGroup[j]==2 ? "A-" : 
                                        bloodGroup[j]==3 ? "B+" : bloodGroup[j]==4 ? "B-" : bloodGroup[j]==5 ? "O+" : 
                                        bloodGroup[j]==6 ? "O-" : bloodGroup[j]==7 ? "AB+" : bloodGroup[j]==8 ? "AB-" : 
                                        "Unknown");
                                    System.out.print(prevDonate[j]==0 ? "\t\tNo History\n" : "\t\t"+don[j]+"\n");
                                    check = true;
                                }
                            }
                            if(!check)
                            {
                                System.out.println("\nNo Match Found!");
                            }
                            System.out.print("\n\nEnter the Donor ID whose blood has to be collected (Enter 0 for none): ");
                            d = sc.nextInt();
                            if(d!=0 && d<=i && !bloodCollected[d-1] && hospital[d-1]==h)
                            {
                                System.out.println("\nAddress of Donor: "+address[d-1]);
                                bloodCollected[d-1]=true;
                                System.out.println("\n\nBlood Collected Successfully!");
                            }
                            else if(d!=0)
                                System.out.println("\nError! Blood Collection not possible!");
                            break;

                            case 2:
                            check = false;
                            do
                            {
                                System.out.print("Enter Blood Group[(1) A+ (2) A- (3) B+ (4) B- (5) O+ "+
                                    "(6) O- (7) AB+ (8) AB- (9) Do not know]: ");
                                bg = sc.nextInt();
                            } while(bg!=1 && bg!=2 && bg!=3 && bg!=4 && bg!=5 && bg!=6 && bg!=7 && bg!=8 && bg!=9);
                            System.out.println("\nDONOR ID\tNAME\t\t\tDOB\t\tGENDER\tPHONE\t\tEMAIL\t\t\t\tHOSPITAL\tPREVIOUS DONATION");
                            for(j=0; j<=i; j++)
                            {
                                if(bloodGroup[j]==bg && !bloodCollected[j])
                                {
                                    System.out.print((j+1)+"\t\t"+name[j]+"\t\t"+dob[j]+"\t"+(gender[j]==1 ? "Male\t" : gender[j]==1 ? "Female\t" : "Other\t")
                                        +phone[j]+"\t"+email[j]+"\t\t\t"+hospital[j]+(prevDonate[j]==0 ? "\t\tNo History\n" : "\t\t"+don[j]+"\n"));
                                    check = true;
                                }
                            }
                            if(!check)
                            {
                                System.out.println("\nNo Match Found!");
                            }
                            System.out.print("\n\nEnter the Donor ID whose blood has to be collected (Enter 0 for none): ");
                            d = sc.nextInt();
                            if(d!=0 && d<=i && !bloodCollected[d-1] && bloodGroup[d-1]==bg)
                            {
                                System.out.println("\nAddress of Donor: "+address[d-1]);
                                bloodCollected[d-1]=true;
                                System.out.println("\n\nBlood Collected Successfully!");
                            }
                            else if(d!=0)
                                System.out.println("\nError! Blood Collection not possible!");
                            break;

                            case 3: System.out.println("\nExiting Hospital Mode!"); break;

                            default: System.out.println("Wrong choice entered!");
                        }
                    }while(c!=3);
                    break;
                }
                else
                    System.out.println("\n\nError! Passcode in not valid!");

                case 3: System.out.println("\nThank you for using the program!"); break;

                default: System.out.println("Wrong choice entered!");
            }
        }while(ch!=3);
    }
}