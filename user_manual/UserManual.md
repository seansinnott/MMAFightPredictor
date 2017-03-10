# Contents Page #
1. Welcome Screens <br>
  1.2 Home Screen 
2. Calculate Mode <br>
  2.1 Choose Fighters <br>
  2.2 User Opinion Option<br>
  2.3 Give Your Opinion<br>
  2.4 Results Screen<br>
3. Create Algorithm Mode <br>
  3.1 Choose Fighters <br>
  3.2 Create Algortihm <br>
  3.3 Give Opinion <br>
  3.4 Results Screen <br>
4. Select A Different Language



# User Manual - MMA Fight Predictor #
Our Project, the MMA Fight Predictor, is an Android Application for which the desired result is to correctly predict the outcome of a Mixed Martial Arts bout between two fighters. This is achieved by the user entering the required information throughout the process, in addition to the app fetching information from its built-in database. This User Manual will breakdown the step-by-step process of how to use the application, including both of its prediction modes, which will be explained thoroughly in this guide. 

## 1. Welcome Screens ##

After installing the application, the user can then open the app by locating it in their mobile phone. After clicking on the app to open it, the user will be presented with an animation of the application logo fading in, while the rest of the software is prepared in the background. This is followed by a series of welcome screens. The aim of these screens is to give the user a brief introduction to how the application works. The user can navigate between these screens by using the “Next” and “Back” buttons. There is also an option to disable these welcome screens on the first screen, by ticking the box labelled “Do not show this again”. As well as this, there is an option to skip these screens and move directly to the home screen by hitting the “Skip” button on the first screen. The second of these screens informs the user about the first of the two modes – the “Create Algorithm” mode. The last of these screen follows the same protocol, by giving a brief introduction to the other mode – “Calculate”. Both modes will be explained in extensive detail later in the user manual. After the user selects the “Got It” button on the last welcome screen, they will progress to the home screen of the application.

![](http://www.student.computing.dcu.ie/~nearyc2/Welcome2.PNG)

### 1.2 Home Screen ###

The home screen is the central hub of the application. From here, every aspect of the application can be accessed, including the two modes of the app, a contact screen, and help link. To access the contact and help screens, the user can simply click on the three dots in the top right corner, from which a menu will be displayed. The user can simply click the Contact button and will be presented with an email address which will enable them to contact us directly. Similarly, the user can click the help button, which will once again display the welcome screens that can be re-read in a case where the user is unsure of what the two modes do. The arrow located at the top left of either of the Contact and Help pages will return the user to the home screen. This arrow is consistent throughout the application, returning the user to the previous screen.

The main feature of the home screen is its ability to access the two different modes of the app, labelled “Create Algorithm” and “Calculate”.

![](http://www.student.computing.dcu.ie/~nearyc2/HomeScreen.PNG)

## 2. Calculate Mode ##

In this section, we will give a concise, yet simple walk-through of the “Calculate” mode. This mode involves using our specially formulated algorithm to predict the outcome of Mixed Martial Arts bouts, including some extra features which add to the users’ experience. 

### 2.1 Choose Fighters ###

When the user selects this mode, they will be presented with a screen consisting of three drop down menus. From here, the user must select the weight division of the two fighters whose fight they wish to receive a prediction on. 

This is achieved by clicking the drop-down menu labelled “Choose Weight Division”, which will be followed by a list containing all the available weight divisions. 

![](http://www.student.computing.dcu.ie/~nearyc2/Fighters2.PNG)

From here, the user can click on the first of the two remaining drop-down menus, labelled “Choose First Fighter”. After clicking this, a list will be displayed containing all the fighters available in that division. Here, the user chooses the first of two fighters.

![](http://www.student.computing.dcu.ie/~nearyc2/Fighters3.PNG)

The user then follows the same procedure to select the opposing fighter, which is available from the final drop-down menu. Once all this information has been selected, the user can click the “GO” button at the bottom of the screen to progress to the next stage of the app. 

If the user attempts to progress without filling in the required information, they will be prompted with a message towards the bottom of the screen indicating that they have omitted some information.

### 2.2 User Opinion Option ###

This screen presents the user with two options. Option one predict the outcome of a fight based purely upon the statistics stored in our database, using our specially formulated algorithm. This option is labelled “statistics”. From here, the user will continue directly to the result screen (Section 3).

Option two is labelled “Give Your Opinion”. This mode enables the user to add their opinion to our algorithm, by choosing which fighter they consider to be more skilled in specific areas of Mixed Martial Arts. This may enhance the outcome of the algorithm. This screen will be explained in further detail later in this manual (Section 2.3).

![](http://www.student.computing.dcu.ie/~nearyc2/GiveOpinion.PNG)

### 2.3 Give Your Opinion ###

This screen gives the user the ability to specify which fighter is more skilled in the three main areas of Mixed Martial Arts. These three areas are “Striking”, “Jiu-Jitsu”, and “Wrestling”.  The user will be presented with a screen that consists of three sliders, one for each of these skill sets. On either side of the sliders, the two fighters’ names are displayed. It is the user’s job to decide which fighter is more skilled in each area using these sliders. This is done by moving the slider towards the chosen fighter. 

![](http://www.student.computing.dcu.ie/~nearyc2/UserSkillOpinion.PNG)

The distance the user chooses to move the slider from its central position will determine how much more advanced the chosen fighter is in this area. If the slider is moved as far as possible to the left, it gives the fighter on the left a “Significant Advantage” in this skillset. Whereas, if the slider is only moved halfway to the left from the centre, it only gives the fighter on the left a “Slight Advantage”. If neither fighter is more skilled in a specific area, the user can choose to leave the slider in the centre, otherwise known as “Neutral”.

The user can also press the back button in the top left of the screen to go back and change previously entered information

Once the user has decided upon these sliders, the button positioned at the bottom of the screen labelled “Predict”, will bring the user to the result screen.

### 2.4 Result Screen ###

On this screen, the prediction for the fight will appear. The screen will begin with a loading screen as the application calculates the outcome. If the app predicts an outright winner, this name will be displayed on the screen. At the top of the view, a percentage is displayed. This percentage represents how certain the app is of the outcome of the bout, meaning that the closer it is to 50%, the closer the fight should be.

A back arrow is also located at the top left corner of the screen, allowing the user to navigate back to previous screens to edit information provided.

The user can navigate back to the home screen by pressing the “Finish” button, located at the bottom of the screen. From here they can enter either of the two modes again (See section 1).

![](http://www.student.computing.dcu.ie/~nearyc2/Result.PNG)

## 3. Create Algorithm Mode ##

### 3.1 Choose Fighters ###

See Section 2.1, Page 3.

### 3.2 Create Algorithm Screen ### 

On this screen, the user is presented with a total of 8 sliders. The purpose of each of these sliders is to rate the importance of each of these attributes for this fight. These attributes are:

Reach – This is the length of the fighters’ arms. The longer a fighters’ arm, the better they are at keeping their opponent out of range, resulting in less damage taken, and increasing their ability to keep the opponent at a distance.

Height – This is the height of each fighter. A significant difference in height can sometimes make the taller fighter harder to hit.

Weight – This is the weight of each fighter. This is important as the heavier fighter can use their weight to keep their opponent pinned to the floor and thus inflicting more damage. This would mostly apply in the heavyweight class, as fighters in other divisions are usually the same weight.

Age – This is the age of each fighter. This is a vital factor as one fighter may be at a young age and in prime physical shape, but may lack experience. While an older fighter may be past their prime physical condition, they may have a vast amount of fighting experience with which they can outclass their opponent. 

Striking – This is how important striking ability is in a particular bout. It may be significant in a fight between two known strikers, but may not be as relevant in a bout between two Jiu-Jitsu artists.

![](http://www.student.computing.dcu.ie/~nearyc2/Create1.PNG)

Jitsu artists.
Jiu-Jitsu – This indicates the effect that a high level of skill in Brazilian Jiu-Jitsu will have on this bout. Similar to the striking slider, it would be important in a bout between two known grapplers, but may not be as important between two strikers. 

Wrestling - In a similar fashion to Striking and Jiu-Jitsu, this rates both fighters’ ability in the wrestling aspect of Mixed Martial Arts. Once again, this may not be important in a bout between two strikers, but it will be in a bout between two skilled wrestlers.

Current Form – This indicates the impact of a fighters’ current form on the outcome of this fight. A fighter on a win-streak may be high on confidence, while a fighter who is suffering consecutive losses may be mentally shaken.

![](http://www.student.computing.dcu.ie/~nearyc2/Create2.PNG)

The user has the option to go back to the previous screen to edit past information by pressing the back arrow in the top left corner.

Once the user has chosen all their preferred weights of importance, they can press the “GO” button at the bottom of the screen to progress to the next stage of the app.

### 3.3 Give Your Opinion ###

See Section 2.3.

### 3.4 Results Screen ###

See Section 2.4.

## 4. Select A Different Language ##

The MMA Fight Predictor comes with four pre-installed languages: English, German, and French. The application recognises which language to use by checking the default language on the users’ device. If the user wishes to change the language, they can do so through Settings > Language & Input.