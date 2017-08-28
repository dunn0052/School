# this program calculates the real roots of a quadratic equation

import math

continueLoop = 'y'

while continueLoop == 'y' :

    #user inputs quadratic coefficients
    
    a = eval(input("Enter coefficient a\n"))

    b = eval(input("Enter coefficient b\n"))

    c = eval(input("Enter coefficient c\n"))

    #discriminant is calculated to categorize root type
    discriminant = b * b - 4 * a * c

    #root types are categorized based upon discriminant 
    if a == 0 :

        x1 = (-c) / b
        print("Your formula is not a quadratic and has a root", round(x1, 2), "\n") 
        
    elif discriminant == 0 :
        
        x1 = -b / (2 * a)
        print("The root is", round(x1, 2), "\n")
        
    elif discriminant > 0 :
        
        x1 = (-b + math.sqrt(discriminant)) / (2 * a)
        x2 = (-b - math.sqrt(discriminant)) / (2 * a)
        print("The roots are", round(x1, 2), "and", round(x2, 2), "\n")

    else :

       print("There are no real roots to this quadratic")

    continueLoop = input("Enter y to continue\n")
