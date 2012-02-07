<project>
    <property name="librarydir" value="${environment.javaEnvironment.libraryDir}" />
	<property name="environmentdir" value="${environment.dir}"/>
	<path id="hibernatepath">
	     <fileset dir="<#noparse>${librarydir}</#noparse>">
	     <include name="*.jar"/>
	     </fileset>
	        <pathelement path="<#noparse>${targetdir}</#noparse>"/>
	   </path>
	<path id="classpath">
		 <path location="classes" />
	</path>

	
	<taskdef name="hibernatetool" 
	         classname="org.hibernate.tool.ant.HibernateToolTask" 
	         classpathref="hibernatepath" />

	
	<target name="hbm2ddl">
		<hibernatetool destdir="D:/RFID/workspace/generated">
		<classpath refid="classpath"/>
			<configuration configurationfile="hibernate.cfg.xml" namingstrategy="org.hibernate.cfg.ImprovedNamingStrategy" >
				<fileset dir="<#noparse>${environmentdir}</#noparse>/temp" casesensitive="yest">
					<include name="**/*.hbm.xml" />
				</fileset>
			</configuration>
		 <hbm2ddl export="true" outputfilename="sql.sql" format="true"/>
		</hibernatetool>
	</target>
	

</project>