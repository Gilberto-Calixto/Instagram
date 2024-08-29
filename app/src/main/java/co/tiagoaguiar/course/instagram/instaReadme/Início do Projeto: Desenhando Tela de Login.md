-> Estilizando componente EditText -> pas/res/values/style

```markdown
    <style name="Theme.Instagram.FormEditText">
        <item name="android:layout_width">match_parent</item>
        <item name="android:layout_height">wrap_content</item>
        <item name="android:padding">16dp</item>
        <item name="android:layout_marginStart">8dp</item>
        <item name="android:layout_marginEnd">8dp</item>
        <item name="android:layout_marginBottom">10dp</item>
        <!-- Adicionando bordas -->
        <item name="android:background">@drawable/edit_text_background</item>
    </style>
```

-> Criando as bordas em um componente no res/drawable/edit_text_background
    
```markdown
    <shape>
        <!-- Cordas bordas e espessura -->
        <stroker android:color="@color/gray" android:width="1dp"  
    
        <!-- Bordas arendondadas -->
        <corners android:rasdius="4dp"
    </shape>
```

-> componente de margens 

```markdown
    <style name="EditFormContainer">
        <item> name 
    </style>
```

-> Botão com cor personalizada ao clicar

    ```markdown
        <!-- Botão com cor personalizada ao clicar   -->
        <style name="Theme.Instagram.Button" parent="Widget.MaterialComponents.Button">
            <item name="android:layout_width">match_parent</item>
            <item name="android:layout_height">wrap_content</item>
    
            <item name="android:textColor">@color/white</item>
            <item name="android:padding">16dp</item>
            <item name="android:layout_marginBottom">24dp</item>
    
            <item name="android:layout_marginStart">36dp</item>
            <item name="android:layout_marginEnd">36dp</item>
    
            <!-- Pintar cor do botão  -->
            <item name="android:backgroundTint">@color/button_background</item>
        </style>
    ```

    -> criar new diretory em res/color -> @color/button_background 
    ```
        <selector xmlns:android="http://schemas.android.com/apk/res/android">
                
            <!-- desativado e ativado ao clicar  -->
            <item android:color="#FFFFFF" android:state_enabled="false"/>
            <item android:color="#6E97FF" android:state_enabled="true"/>    

        </selector>
    ```
    
