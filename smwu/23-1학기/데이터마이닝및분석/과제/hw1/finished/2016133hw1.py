# This Python 3 environment comes with many helpful analytics libraries installed
# It is defined by the kaggle/python Docker image: https://github.com/kaggle/docker-python
# For example, here's several helpful packages to load

import numpy as np # linear algebra
import pandas as pd # data processing, CSV file I/O (e.g. pd.read_csv)
import seaborn as sns

# Input data files are available in the read-only "../input/" directory
# For example, running this (by clicking run or pressing Shift+Enter) will list all files under the input directory

import os
for dirname, _, filenames in os.walk('/kaggle/input'):
    for filename in filenames:
        print(os.path.join(dirname, filename))

# You can write up to 20GB to the current directory (/kaggle/working/) that gets preserved as output when you create a version using "Save & Run All" 
# You can also write temporary files to /kaggle/temp/, but they won't be saved outside of the current session


train = pd.read_csv('/kaggle/input/datamininghw1/train.csv')
test = pd.read_csv('/kaggle/input/datamininghw1/test.csv')
train.info() #결측치 확인
train.duplicated().sum() #중복값 확인


## 분포를 plot으로
ax = sns.countplot(x = 'room_type_reserved', data = train)


train = train.replace({'Room_Type 1':1, 'Room_Type 2':0, 'Room_Type 3':0, 'Room_Type 4':0, 
                       'Room_Type 5':0, 'Room_Type 6':0, 'Room_Type 7':0})
train['room_type_reserved'] = train['room_type_reserved'].astype(np.int64)
ax = sns.countplot(x = 'room_type_reserved', data = train)


# ax = sns.countplot(x = 'market_segment_type', data = train)
train = train.replace({'Offline':0, 'Online':1, 'Corporate':2, 'Aviation':2, 'Complementary':2})
ax = sns.countplot(x = 'market_segment_type', data = train)


train = train.replace({'Not Selected':0, 'Meal Plan 1':1, 'Meal Plan 2':0, 'Meal Plan 3':0})
train['type_of_meal_plan'] = train['type_of_meal_plan'].astype(np.int64)
ax = sns.countplot(x = 'type_of_meal_plan', data = train)


train = train.replace({0:0, 1:1, 2:1, 3:1, 4:1, 5:1, 6:1, 11:1, 13:1})
train['no_of_previous_cancellations'] = train['no_of_previous_cancellations'].astype(np.int64)
ax = sns.countplot(x = 'no_of_previous_cancellations', data = train)


from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score
from sklearn.tree import DecisionTreeClassifier

feature_names = ["avg_price_per_room", "required_car_parking_space", "lead_time", 
                 "no_of_previous_cancellations", "room_type_reserved",
                 "market_segment_type","repeated_guest","no_of_special_requests"]
X = train[feature_names]
y = train["booking_status"]

# Decision Tree 학습/예측/평가
X_train, X_test, y_train, y_test = train_test_split(X,y)
dt_model = DecisionTreeClassifier()
dt_model.fit(X_train,y_train)
dt_pred = dt_model.predict(X_test)
print('DecisionTreeClassifier 정확도: {0:.4f}'.format(accuracy_score(y_test, dt_pred)))


test = test.replace({'Room_Type 1':1, 'Room_Type 2':0, 'Room_Type 3':0, 'Room_Type 4':0, 
                       'Room_Type 5':0, 'Room_Type 6':0, 'Room_Type 7':0})
test['room_type_reserved'] = test['room_type_reserved'].astype(np.int64)

test = test.replace({'Offline':0, 'Online':1, 'Corporate':2, 'Aviation':2, 'Complementary':2})
test['room_type_reserved'] = test['room_type_reserved'].astype(np.int64)

test = test.replace({'Not Selected':0, 'Meal Plan 1':1, 'Meal Plan 2':0, 'Meal Plan 3':0})
test['type_of_meal_plan'] = test['type_of_meal_plan'].astype(np.int64)

test = test.replace({0:0, 1:1, 2:1, 3:1, 4:1, 5:1, 6:1, 11:1, 13:1})
test['no_of_previous_cancellations'] = test['no_of_previous_cancellations'].astype(np.int64)

x_test = test[feature_names]



prediction_list= dt_model.predict(x_test)

submit = pd.read_csv("/kaggle/input/datamininghw1/sample_submission.csv")
submit["booking_status"] = prediction_list
submit = submit.replace({'Canceled':1, 'Not_Canceled':0})
submit


submit.to_csv("2016133_submit.csv",index=False)