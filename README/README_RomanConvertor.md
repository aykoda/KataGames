<b>Roman Convertor Kata</b><br>

Implementation: <br>
Modeling of class structure represented by UML and related testing constraints that will continue to be developed by the Test Driven Development approach - Red-Green-Refactor.
<br><br>
<b>Definitions and restrictions:</b><br><br>
The Roman convertor implementation is based on  constant set of Roman representation of the10th based numbers by 1 and 5. The main rule of solution is based on determination of lower and upper values of a Numeral that will be converted in the range of the constant Roman set. For this, the NavigableMap structure is used, which implements the LowerKey and UpperKey methods.

If the numeric value of the input is found in the RomanNumber set, the represented Roman value is taken.

If not found, the representing Roman value is calculated. In the cases of Regular and Irregular Romans, such as 4 and 9, the calculation of formulas is applied differently.


In the case of the regular Roman number, It is retrieved the represeting Roman value of the lower range and its repeat recursively  in that way for the next value that is the substraction of Numerals  input with Lower.


In the case of an Irregular Romans, such as 4 and 9, the result would be the concatenation of lower and upper Roman values. Also the calculation of the rest numeral  value is applied differently. Specially in the case of 9 the lower value would be the second lower in the range.

<img width="50%" height="50%" src="https://user-images.githubusercontent.com/95845154/153743432-58c6ea60-5cfe-490c-9913-bb34a3bb3951.png">
