Все практические задания выполняются на открытом стенде https://the-internet.herokuapp.com/
---------------------------------------------------------------------------------

1. Добавить проверки в задание Checkboxes из предыдущей лекции. Проверять корректное состояние каждого чекбокса после каждого нажатия на него. Запустить тест с помощью @ParametrizedTest, изменяя порядок нажатия на чекбоксы с помощью одного параметра.

2. Добавить проверки в задание Dropdown из предыдущей лекции. Проверять корректное состояние каждого dropDown после каждого нажатия на него.

3. Добавить проверки в задание Disappearing Elements из предыдущей лекции. Для каждого обновления страницы проверять наличие 5 элементов. Использовать @RepeatedTest.

4. Добавить проверки в задание Inputs из предыдущей лекции. Проверить, что в поле ввода отображается именно то число, которое было введено. Повторить тест 10 раз, используя @TestFactory, с разными значениями, вводимыми в поле ввода. Создать проверку негативных кейсов (попытка ввести в поле латинские буквы, спецсимволы, пробел до и после числа).

5. Добавить проверки в задание Hovers из предыдущей лекции. При каждом наведении курсора, проверить, что отображаемый текст совпадает с ожидаемым. Выполнить тест с помощью @ParametrizedTest, в каждом тесте, указывая на какой элемент наводить курсор

6. Добавить проверки в задание Notification Message из предыдущей лекции. Добавить проверку, что всплывающее уведомление должно быть Successfull. Если нет – провалить тест. Использовать @RepeatedTest.

7. Добавить проверки в задание Add/Remove Elements. Проверять, что на каждом шагу остается видимым ожидаемое количество элементов. Запустить тест три раза, используя @TestFactory, меняя количество созданий и удалений на 2:1, 5:2, 1:3 соответственно.

8. Добавить проверки в задание Status Codes. Добавить Проверку, что переход был осуществлен на страницу с корректным статусом.

9. Добавить в Allure Listener так, чтобы записывались действия с элементами. По желанию можно внедрить в код аннотацию @Step.

---------------------------------------------------------------------------------




