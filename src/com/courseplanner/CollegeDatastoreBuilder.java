package com.courseplanner;

import java.util.ArrayList;

import com.google.appengine.api.datastore.*;


public class CollegeDatastoreBuilder {
	
	public void insertMuirInfo () {
		
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

		String[] muirGE = {"MCWP 40","MCWP 50"};
		ArrayList<Entity> entities_to_write = new ArrayList<Entity>();
		
		// Strings of table html for misc GEs
		Text miscText = new Text("Choose 3 courses from one of the sequences listed below.");
		Text area1 = new Text("<table><tbody> <tr> <td>Sequence</td> <td>Course 1</td> <td>Course 2</td> <td>Course 3</td> </tr> <tr> <td><sup>Anthropology</sup></td> <td>ANTH 1</td> <td>ANTH 2</td> <td>ANTH 3</td> </tr> <tr> <td><sup>Cognitive Science</sup></td> <td>COGS 1</td> <td>COGS 11</td> <td>COGS 10 or<br> COGS 17</td> </tr> <tr> <td><sup>Critical Gender Studies</sup></td> <td>CGS 2A</td> <td>CGS 2B</td> <td>CGS 100</td> </tr> <tr> <td><sup>Economics</sup></td> <td>ECON 1</td> <td>ECON 2</td> <td>ECON 3</td> </tr> <tr> <td><sup>Ethnic Studies</sup></td> <td>ETHN 1</td> <td>ETHN 2</td> <td>ETHN 3</td> </tr> <tr> <td><sup>Linguistics</sup></td> <td>Choose 3 from LIGN 3, 4, 7, or 8</td> </tr> <tr> <td><sup>Political Science</sup></td> <td>Choose 3 from POLI 10, 11, 12, or 13</td> </tr> <tr> <td><sup>Psychology</sup></td> <td>Choose 3 from PSYC 1, 2, 3, 4, 6, or 7</td> </tr> <tr> <td><sup>Sociology</sup></td> <td>SOCI 1</td> <td>SOCI 2</td> <td>One from SOCI 10, 20, 30, 40 or 50</td> </tr> <tr> <td><sup>Urban Studies &amp; Planning</sup></td> <td>USP 1</td> <td>USP 2</td> <td>USP 3</td> </tr> </tbody></table>");
		Text area2 = new Text("<table><tbody> <tr> <td>Sequence</td> <td>Course 1</td> <td>Course 2</td> <td>Course 3</td> </tr> <tr> <td><sup>Biology (non-science majors)</sup></td> <td>BILD 10</td> <td>Choose 2 from BILD 7, 12, 20, 22, 24, 26, 30, 32, or 36</td> </tr> <tr> <td><sup>Calculus</sup></td> <td>MATH 10A</td> <td>MATH 10B</td> <td>MATH 10C</td> </tr> <tr> <td><sup>Calculus (engineering)</sup></td> <td>MATH 20A</td> <td>MATH 20B</td> <td>MATH 20C</td> </tr> <tr> <td><sup>Chemistry (non-science majors)</sup></td> <td>CHEM 11</td> <td>CHEM 12</td> <td>CHEM 13</td> </tr> <tr> <td><sup>Chemistry</sup></td> <td>CHEM 6A</td> <td>CHEM 6B</td> <td>CHEM 6C</td> </tr> <tr> <td><sup>Earth Science (non-science majors)</sup></td> <td>Choose 3 from SIO 1, 10, 20 or 30</td> </tr> <tr> <td><sup>Environmental Studies (non-science majors)</sup></td> <td>ENVR 30</td> <td>Choose 2 from BILD 18, PHYS 12, or SIO 25</td> </tr> <tr> <td><sup><span>Environmental Studies (non-science majors)</span></sup></td> <td>ENVR 30</td> <td>One from BILD 18, PHYS 12, or SIO 25</td> <td>ENVR 130 or 140</td> </tr> <tr> <td><sup>Physics (biological sciences)</sup></td> <td>PHYS 1A+1AL</td> <td>PHYS 1B+1BL</td> <td>PHYS 1C+1CL</td> </tr> <tr> <td><sup>Physics (engineering)</sup></td> <td>PHYS 2A</td> <td>PHYS 2B</td> <td>PHYS 2C</td> </tr> <tr> <td><sup>Physics (non-science majros)</sup></td> <td>Choose 3 from PHYS 5, 6, 7, 8, 9, 10, or 11</td> </tr> <tr> <td><sup>Physics (physics majors)</sup></td> <td>PHYS 4A</td> <td>PHYS 4B</td> <td>PHYS 4C</td> </tr> </tbody></table>");
		Text area3 = new Text("<table><tbody> <tr> <td>Sequence</td> <td>Course 1</td> <td>Course 2</td> <td>Course 3</td> </tr> <tr> <td><sup>Art History</sup></td> <td>Choose 3 from VIS 20, 21A, 21B, or 22</td> </tr> <tr> <td><sup>Film Studies</sup></td> <td>VIS 22</td> <td>VIS 84</td> <td>One from VIS 152, 153, 154, or 155</td> </tr> <tr> <td><sup>Music Fundamentals</sup></td> <td>MUS 1A</td> <td>MUS 1B</td> <td>MUS 1C</td> </tr> <tr> <td><sup>Music Traditions</sup></td> <td>MUS 4</td> <td>Choose 2 from MUS 5, 7, 8, 9, 10, 11, 12, 13AF, 13AM, 13AS, 14, or 15</td> </tr> <tr> <td><sup>Theatre History</sup></td> <td>Choose 3 from TDHT 10, 21, 22 or 23</td> </tr> <tr> <td><sup>Theatre</sup></td> <td>TDGE 1</td> <td>Choose 2 from TDAC 1, TDDE 1, TDGE 10 or TDPW 1</td> </tr> <tr> <td><sup>Visual Arts</sup></td> <td>Choose 2 from&nbsp;VIS 1, 2, or 3</td> <td>VIS 111</td> </tr> </tbody></table><table> <tbody> <tr> <td>Sequence</td> <td>Course 1</td> <td>Course 2</td> <td>Course 3</td> </tr> <tr> <td><sup>American Sign Language</sup></td> <td>Choose 3 from<br> LISL 1A+1AX, 1B+1BX, 1C+1CX, or 1D+1DX</td> </tr> <tr> <td><sup>Ancient Greek</sup></td> <td>LTGK 1</td> <td>LTGK 2</td> <td>LTGK 3</td> </tr> <tr> <td><sup>Arabic</sup></td> <td>LIAB 1A+1AX</td> <td>LIAB 1B+1BX</td> <td>LIAB 1C+1CX</td> </tr> <tr> <td><sup>Chinese</sup></td> <td>Choose 3 from<br> CHIN 10A, 10 B, 10C, 20A, 20B, or 20C</td> </tr> <tr> <td><sup>French</sup></td> <td>Choose 3 from&nbsp;LIFR 1A+1AX, 1B+1BX, 1C+1CX, or 1D+1DX; or&nbsp;<span>LTFR 2A, 2B, 2C, or 50</span></td> </tr> "
				+ "<tr> <td><sup>German</sup></td> <td>Choose 3 from&nbsp;LIGM 1A+1AX<span>, 1B+1BX, 1C+1CX, or 1D+1DX; or LTFR 2A, 2B, 2C or 50</span></td> </tr> <tr> <td><sup>Hebrew</sup></td> <td>JUDA 1</td> <td>JUDA 2</td> <td>JUDA 3</td> </tr> <tr> <td><sup>Italian</sup></td> <td><span>Choose 3 from&nbsp;LIIT 1A+1AX</span><span>, 1B+1BX, 1C+1CX, or 1D+1DX; or LTIT 2A, 2B or 50</span></td> </tr> <tr> <td><sup>Japanese</sup></td> <td>Choose 3 from<br> JAPN 10A, 10B, 10C, 20A, 20B, or 20C</td> </tr> <tr> <td><sup>Korean</sup></td> <td>Choose 3 from LTKO 1A, 1B, 1C, 2A, 2B, or 2C</td> </tr> <tr> <td><sup>Latin</sup></td> <td>LTLA 1</td> <td>LTLA 2</td> <td>LTLA 3</td> </tr> <tr> <td><sup>Portuguese</sup></td> <td>LIPO 1A+1AX</td> <td>LIPO 1B+1BX</td> <td>LIPO 1C+1CX</td> </tr> <tr> <td><sup>Russian</sup></td> <td>Choose 3 from LTRU 1A, 1B, 1C, 2A, 2B, or 2C</td> </tr> <tr> <td><sup>Spanish</sup></td> <td><span>Choose 3 from&nbsp;LISP 1A+1AX</span><span>, 1B+1BX, 1C+1CX, or 1D+1DX; LISP 2A, 2B, 2C, 2D, 2E, 50A, 50B, or 50C</span></td> </tr> </tbody> </table><table> <tbody> <tr> <td>Sequence</td> <td>Course 1</td> <td>Course 2</td> <td>Course 3</td> </tr> <tr> <td><sup>British &amp; American Literature</sup></td> <td>Choose 3 from LTEN 22, 23, 25, or 26</td> </tr> <tr> <td><sup>Fiction &amp; Film in 20th Century</sup></td> <td>Choose 3 from LTWL 4A, 4B, 4C, 4D, 4F, or 4M</td> </tr> <tr> <td><sup>Fiction, Poetry, &amp; Non-Fiction Writing</sup></td> <td>LTWR 8A</td> <td>LTWR 8B</td> <td>LTWR 8C</td> </tr> <tr> <td><sup>History of China and"
				+ " Japan</sup></td> <td>HILD 10</td> <td>HILD 11</td> <td>HILD 12</td> </tr> <tr> <td><sup>History of Philosophy</sup></td> <td>PHIL 31</td> <td>PHIL 32</td> <td>PHIL 33</td> </tr> <tr> <td><sup>Introduction to Greeks &amp; Romans</sup></td> <td>LTWL 19A</td> <td>LTWL 19B</td> <td>LTWL 19C</td> </tr> <tr> <td><sup>Introduction to Philosophy</sup></td> <td>Choose 3 from PHIL 1, 13, 14, or 15</td> </tr> <tr> <td><sup>Race &amp; Ethnicity in U.S. History</sup></td> <td>HILD 7A</td> <td>HILD 7B</td> <td>HILD 7C</td> </tr> <tr> <td><sup>Race &amp; Ethnicity in U.S. Literature</sup></td> <td>LTEN 27</td> <td>LTEN 28</td> <td>LTEN 29</td> </tr> <tr> <td><sup>Third World Literature</sup></td> <td>Choose 3 from TWS 21, 22, 23, 24, 25 or 26</td> </tr> <tr> <td><sup>U.S. History</sup></td> <td>HILD 2A</td> <td>HILD 2B</td> <td>HILD 2C</td> </tr> </tbody> </table>");
		
		Entity college = new Entity("CollegeTable");
		datastore.put(college);

		Entity Muir = new Entity("College", college.getKey());
		datastore.put(Muir);
		
		Muir.setProperty("name", "Muir");
		Muir.setProperty("description", "Muir College encourages awareness of environmental "
				   + "issues and involvement in environmental preservation and "
				   + "sustainability.");

		for (int i = 0; i < muirGE.length; i++) {
			Entity muirGEReq = new Entity("GEReqCourse",Muir.getKey());
			muirGEReq.setProperty("CourseID",muirGE[i]);
			entities_to_write.add(muirGEReq);
		}
		
		Entity muir_misc_GEReq = new Entity("MiscGEReqCourse",Muir.getKey());
		muir_misc_GEReq.setProperty("Misc Text", miscText);
		muir_misc_GEReq.setProperty("Area 1", area1);
		muir_misc_GEReq.setProperty("Area 2", area2);
		muir_misc_GEReq.setProperty("Area 3", area3);
		entities_to_write.add(muir_misc_GEReq);
		
		datastore.put(entities_to_write);

	}
	public void insertMarshallInfo () {
		
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

		String[] marshallGE = {"DOC 1","DOC 2", "DOC 3"};
		ArrayList<Entity> entities_to_write = new ArrayList<Entity>();
		
		// Strings of table html for misc GEs
		Text miscText = new Text("Students must complete two (2) courses for Mathematics, Statistics and Logic. Both May come from the Mathematics/Advanced Statistic category.  However, at most, one course may be selected from each of the other categories.");
		Text area2 = new Text("<table> <tbody> <tr>Mathematics/Advanced Statistics</tr> <tr><td>BIEB 100</td></tr> <tr><td>MATH 180A or 181A</td></tr> <tr><td>MATH 4C</td></tr> <tr><td>MATH 10A</td></tr> <tr><td>MATH 10B</td></tr> <tr><td>MATH 10C</td></tr> <tr><td>MATH 20A</td></tr> <tr><td>MATH 20B</td></tr> <tr><td>MATH 20C</td></tr> </tbody> </table>");
		Text area3 = new Text(" <table> <tbody> <tr>Introductory Statics</tr> <tr><td>COGS 14</td></tr> <tr><td>POLI 30</td></tr> <tr><td>PSYC 60</td></tr> <tr><td>SOCL 60</td></tr> </tbody> </table>");
		Text area4 = new Text(" <table> <tbody> <tr>Computer Programming & Logic</tr> <tr><td>CSE 5A</td></tr> <tr><td>CSE 8A</td></tr> <tr><td>CSE 11</td></tr> <tr><td>ECE 85</td></tr> <tr><td>LIGN 17</td></tr> <tr><td>MAE 5</td></tr> <tr><td>MAE 9</td></tr> <tr><td>PHIL 10</td></tr> <tr><td>PHIL 12</td></tr> </tbody> </table>");
		Entity college = new Entity("CollegeTable");
		datastore.put(college);

		Entity marshall = new Entity("College", college.getKey());
		datastore.put(marshall);
		
		marshall.setProperty("name", "Marshall");
		Text marshallDesc = new Text("Thurgood Marshall College, formerly known as Third College, was founded in 1970 in a period "
				+ "of transformative social change in the United States and the world. From its beginning, the college has enriched the "
				+ "lives of undergraduates with a commitment to the development of young people as both professionals and engaged citizens. "
				+ "In 1993, the college was named in honor of former U.S. Supreme Court Justice Thurgood Marshall. Justice Marshall is well "
				+ "known for his dedication to educational opportunity for all, civil rights, freedom of speech, women’s rights, and the "
				+ "right to privacy.");
		marshall.setProperty("description",marshallDesc);

		for (int i = 0; i < marshallGE.length; i++) {
			Entity marshallGEReq = new Entity("GEReqCourse",marshall.getKey());
			marshallGEReq.setProperty("CourseID",marshallGE[i]);
			entities_to_write.add(marshallGEReq);
		}
		
		Entity marshall_misc_GEReq = new Entity("MiscGEReqCourse",marshall.getKey());
		marshall_misc_GEReq.setProperty("Misc Text", miscText);
		marshall_misc_GEReq.setProperty("Area 1", area2);
		marshall_misc_GEReq.setProperty("Area 2", area3);
		marshall_misc_GEReq.setProperty("Area 3", area3);

		entities_to_write.add(marshall_misc_GEReq);
		datastore.put(entities_to_write);

	}
	public void insertRevelleInfo () {
		
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

		String[] revelleGE = {"HUM 1","HUM 2", "HUM 3", "HUM 4", "HUM 5"};
		ArrayList<Entity> entities_to_write = new ArrayList<Entity>();
		
		// Strings of table html for misc GEs
		Text miscText1 = new Text("Either the Math 10 series or 20 series must be taken for letter grades.");
		Text area1 = new Text(" <table> <tbody> <tr>Calculus Requirements</tr> <tr><td>MATH 10A</td></tr> <tr><td>MATH 10B</td></tr> <tr><td>MATH 10C</td></tr> <tr><td>MATH 20A</td></tr> <tr><td>MATH 20B</td></tr> <tr><td>MATH 20C</td></tr> </tbody> </table>");
		
		Text miscText2 = new Text("Four courses in physical science From both chemistry and physics. One course in biology"
				+ "Science, Engineering and Math majors must take this requirement for a LETTER GRADE."
				+ "Arts, Humanities, and Social Science majors may take the requirement PASS/NOT PASS.");
		Text area2 = new Text("<table> <tbody> <tr> <td > <div> <p><strong><br> <span>Approved Courses</span></strong><br> <strong>(Prerequisites are listed only for the first course in each sequence)</strong></p> </div> </td> </tr> <tr> <td > <p><strong>CHEMISTRY</strong></p>  </td> <td>When Offered</td> </tr> <tr> <td ><strong>Sequence For Arts, Humanities, and Social Science Majors:</strong></td> </tr> <tr> <td >CHEM 11</td> <td>The Periodic Table- No credit after Chem 4, okay for credit after Chem 6A<br> </td> <td>F</td> </tr> <tr> <td>CHEM 12</td> <td>Molecules and Reactions</td> <td>W</td> </tr> <tr> <td>CHEM 13</td> <td>Chemistry of Life</td> <td>S</td> </tr> <tr> <td>&nbsp;</td> </tr> <tr> <td ><strong>Prep For Science Majors (with insufficient preparation):</strong></td> </tr> <tr> <td>CHEM 4</td> <td>Basic Chemistry - prep for Chem 6A, lab included<br> <em><em>Prerequisite: Math 3C or 4C (maybe taken concurrently) or higher level calculus course.</em></em></td> <td>F</td> </tr> <tr> <td><strong>Sequence For Science Majors:</strong></td> <td>&nbsp;</td> </tr> <tr> <td>CHEM 6A</td> <td>General Chemistry<br> <em><em>Prerequisite: Proficiency in high school chemistry. Concurrent enrollment in Math 10A or 20A or higher level calculus.</em></em><br> </td> <td>F, W, S</td> </tr> <tr> <td>CHEM 6B</td> <td>General Chemistry<br> <em>Prerequisite: Completion of Math 20A or 10A required for enrollment.</em></td> <td>F, W, S</td> </tr> <tr> <td>CHEM 6C</td> <td>General Chemistry</td> <td>F, W, S</td> </tr> <tr> <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td> </tr> <tr> <td>CHEM 6AH</td> <td>Honors General ChemistrySequence<br> <em><em>Prerequisite: Proficiency in high school chemistry, physics and mathematics. Concurrent enrollment in Math 20A or higher level calculus</em></em><br> </td> <td>F</td> </tr> <tr> <td>CHEM 6BH</td> <td>Honors General Chemistry</td> <td>W</td> </tr> <tr> <td>CHEM 6CH</td> <td>Honors General Chemistry</td> <td>S</td> </tr> <tr> <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td> </tr> <tr> <td ><strong>PHYSICS</strong></td> </tr> <tr> <td ><strong>For Arts, Humanities, and Social Science Majors:</strong></td> </tr> <tr> <td>PHYS 10</td> <td> <p>Concepts in Physics<br> <em>Prerequisite: College Algebra or equivalent</em></p> </td> <td>W</td> </tr> <tr> <td>PHYS 11</td> <td>Survey of Physics<br> <em>Prerequisite: Math 10A or 20A and concurrent enrollment in Math 10B or 20B</em></td> <td>F</td> </tr> <tr> <td ><strong>Acceptable for Biology Majors:</strong><br> (Course and lab must be taken concurrently)<br> </td> </tr> <tr> <td>PHYS 1A<br> PHYS 1AL<br> </td> <td>Mechanics (3 Units)<br> Mechanics Lab (2 Units)<br> <em>Prerequisite: Math 10A or 20A and concurrent enrollment in Math 10B or 20B</em><br> </td> <td>F,W,S</td> </tr> <tr> <td>PHYS 1B<br> PHYS 1BL<br> </td> <td>Electricity and Magnetism (3 Units)<br> Electricity and Magnetism Lab (2 Units)<br> </td> <td>F,W,S</td> </tr> <tr> <td>PHYS 1C<br> PHYS 1CL<br> </td> <td>Waves, Optics, and Modern Physics (3 Units)<br> Waves, Optics, and Modern Physics Lab (2 Units)<br> </td> <td>F,W,S</td> </tr> <tr> <td >&nbsp;</td> </tr> <tr> <td ><strong>For Engineering, Physical Science, and recommended for Molecular Biology Majors:</strong></td> </tr> <tr> <td>PHYS 2A</td> <td>Physics - Mechanics<br> <em><em>Prerequisite: Math 20A and concurrent enrollment in Math 20B</em></em></td> <td>F,W,S</td> </tr> <tr> <td>PHYS 2B</td> <td>Physics - Electricity and Magnetism</td> <td>F,W,S</td> </tr> <tr> <td>PHYS 2C</td> <td>Physics - Fluids, Waves, Thermodynamics, Optics</td> <td>F,W,S</td> </tr> <tr> <td>PHYS 2D</td> <td>Physics - Relativity and Quantum Physics</td> <td>F,W,S</td> </tr> <tr> <td ><strong>For Physics Majors (and students with a strong interest in physics):</strong></td> </tr> <tr> <td>PHYS 4A</td> <td>Physics for Physics Majors - Mechanics<br> <em><em>Prerequisite: Math 20A and concurrent enrollment in Math 20B</em></em></td> <td>W</td> </tr> <tr> <td>PHYS 4B</td> <td>Mechanics, Fluids, Waves &amp; Heat</td> <td>S</td> </tr> <tr> <td>PHYS 4C</td> <td>Electricity and Magnetism</td> <td>F</td> </tr> <tr> <td>PHYS 4D</td> <td>Electromagnetic Waves, Optics, and Special Relativity</td> <td>W</td> </tr> <tr> <td>PHYS 4E</td> <td>Quantum Physics</td> <td>S</td> </tr> <tr> <td >&nbsp;</td> </tr> <tr> <td ><strong>BIOLOGY</strong></td> </tr> <tr> <td ><strong>For Arts, Humanities, and Social Science Majors:</strong></td> </tr> <tr> <td>BILD 10</td> <td>Fundamental Concepts of Modern Biology</td> <td>Check with Biology Department</td> </tr> <tr> <td >&nbsp;</td> </tr> <tr> <td ><strong>Prep For Science Majors (with insufficient preparation):</strong></td> </tr> <tr> <td>BILD 1</td> <td>The Cell<br> <em><em>Prerequisite: Chem 6A; Chem 6B may be taken concurrently.</em><br> </em></td> <td>F, W, S</td> </tr> <tr> <td>BILD 3</td> <td>Organismic and Evolutionary Biology</td> <td>F, W, S</td> </tr> <tr> <td ><strong>LABS:</strong> No labs are required for General Education requirements for Revelle College, but they may be required by the department or your major. Check UCSD General Catalog for majors requiring specific labs.</td> </tr> </tbody>");
		Text miscText3 = new Text("One course in American Cultures is required. The requirement may be taken PASS/NOT PASS. AP or IB credit may not be used to satisfy this requirement.");
		Text area3 = new Text("<table> <tbody> <tr>Approved American Culture Courses</tr> <tr><td>ANTH 23</td></tr> <tr><td>ETHN 1</td></tr> <tr><td>ETHN 2</td></tr> <tr><td>ETHN 3</td></tr> <tr><td>HILD 7A</td></tr> <tr><td>HILD 7B</td></tr> <tr><td>HILD 7C</td></tr> <tr><td>LIGN 7</td></tr> <tr><td>LIGN 8</td></tr> <tr><td>SOCI 1</td></tr> <tr><td>USP 1</td></tr> </tbody> </table>");
		Text miscText4 = new Text("Two lower division courses (4 units each) from the same social science department are required. This requirement must be taken for a LETTER GRADE.");
		Text area4 = new Text("<table> <tbody> <tr>Social Science Requirement</tr> <tr><td>Anthropology (ANTH)</td></tr> <tr><td>Critical Gender Studies (CGS)</td></tr> <tr><td>Economics (ECON)</td></tr> <tr><td>Ethnic Studies (ETHN)</td></tr> <tr><td>Human Development (HDP)</td></tr> <tr><td>Linguistics/General (LIGN)</td></tr> <tr><td>Political Science (POLI)</td></tr> <tr><td>Psychology (PSYC)</td></tr> <tr><td>Sociology (SOCI)</td></tr> <tr><td>Urban Studies (USP)</td></tr> </tbody> </table>");
		Text miscText5 = new Text("One course is required, to be chosen from the departments of Music, Theatre, and Dance, or Visual Arts. This requirement may be taken PASS/NOT PASS. Any course from Music, Theatre, and Dance, or Visual Arts is acceptable (2 - 4 units).");
		Text area5 = new Text("Basic conversational and reading proficiency in a modern foreign language, or advanced reading proficiency in a classical language is required. This requirement may be taken PASS/NOT PASS. The language requirement may be satisfied by:"
				+ "Passing a foreign language proficiency exam which consists of a satisfactory score on a standard reading examination and conversational proficiency in an oral interview. Completion of a fourth quarter (or higher level) college language course (completion of a third semester Intermediate level course if taken outside of UCSD). Appropriate AP or IB score (see chart). Score of 700 or higher on the SAT Subject Test in a foreign language. A native speaker of a language other than English and having attended at least one year of high school taught in that language.");
		Text miscText6 = new Text("Revelle College requires students to explore an area outside of their major field. This requirement may be met in one of the following two ways: THE AREA OF FOCUS Three courses (12 units) in an area noncontiguous to the major focused in one department subject area, or topic. OR THE MINOR Seven courses (28 units) at least five of which must be upper division, and a minimum of three courses noncontiguous to the major. Additional courses may be required by some departments. Exception: Lit/Language minors require three lower division and four upper division courses.");

		Entity college = new Entity("CollegeTable");
		datastore.put(college);

		Entity revelle = new Entity("College", college.getKey());
		datastore.put(revelle);
		
		revelle.setProperty("name", "Revelle");
		Text revelleDesc = new Text("Revelle College, established in 1964, was the first college established at UCSD.  It was named in honor of UCSD's founder, Roger Revelle, a man the New York Times described as one of the world's most articulate spokesmen for science. A recipient of the President's Medal for Science, Revelle is best known for his seminal work on global warming.");
		revelle.setProperty("description",revelleDesc);

		for (int i = 0; i < revelleGE.length; i++) {
			Entity revelleGEReq = new Entity("GEReqCourse",revelle.getKey());
			revelleGEReq.setProperty("CourseID",revelleGE[i]);
			entities_to_write.add(revelleGEReq);
		}
		
		Entity revelle_misc_GEReq = new Entity("MiscGEReqCourse",revelle.getKey());
		revelle_misc_GEReq.setProperty("Misc Text 1", miscText1);
		revelle_misc_GEReq.setProperty("Area 1", area1);
		revelle_misc_GEReq.setProperty("Misc Text 2", miscText2);
		revelle_misc_GEReq.setProperty("Area 2", area2);
		revelle_misc_GEReq.setProperty("Misc Text 3", miscText3);
		revelle_misc_GEReq.setProperty("Area 3", area3);
		revelle_misc_GEReq.setProperty("Misc Text 4", miscText4);
		revelle_misc_GEReq.setProperty("Area 4", area4);
		revelle_misc_GEReq.setProperty("Misc Text 5", miscText5);
		revelle_misc_GEReq.setProperty("Area 5", area5);
		revelle_misc_GEReq.setProperty("Misc Text 6", miscText6);

		entities_to_write.add(revelle_misc_GEReq);
		datastore.put(entities_to_write);

	}
	public void insertERCInfo () {
		
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

		String[] ERCGE = {"MMW 11","MMW 12", "MMW 13", "MMW 14", "MMW 15"};
		ArrayList<Entity> entities_to_write = new ArrayList<Entity>();
		
		// Strings of table html for misc GEs
		Text miscText1 = new Text("Two courses from an approved list.");
		Text area1 = new Text("<table> <tbody> <tr> <td > <h3>Courses intended for non-math, non-science/engineering majors and<br> non-Pre-Medical Students</h3> <table> <tbody> <tr> <td> <h3>FORMAL LOGIC</h3> <ul> <li>LIGN 17&nbsp; — Making &amp; Breaking Codes</li> <li>PHIL 10 — Introduction to Logic</li> <li>PHIL 12&nbsp; — Scientific Reasoning</li> </ul> </td> </tr> <tr> <td> <h3>STATISTICS</h3> <ul> <li>COGS 14&nbsp; ‡ — Design &amp; Analysis of Experiments</li> <li>POLI 30&nbsp; ‡ — Political Inquiry</li> <li>PSYC 60&nbsp; ‡ — Introduction to Statistics</li> <li>SOCI 60&nbsp; ‡ — The Practice of Social Research</li> <li>CSE 3 — Fluency in Information Technology</li> <li>MAE 5&nbsp; — Quantitative Computer Skills</li> <li>MATH 11 (and *11L) - Elementary Probability &amp; Statistic</li> </ul> <h3>OTHER</h3> <ul> <li>ECE 85 — iTunes 101</li> <li>MGT 3 — Quantitative Methods in Business</li> </ul> <p><em>‡ Not recommended during your first quarter at UC San Diego.</em><br> <em>* 11L not required by ERC but is course co-requisite</em></p> </td> </tr> </tbody> </table> </td> <td>&nbsp;</td> <td > <h3>Courses intended for math, science/engineering majors and Pre-Medical Students</h3> <table > <tbody> <tr> <td> <h3>MATHEMATICS</h3> <ul> <li>MATH 3C # — Pre-Calculus</li> <li>MATH 4C # — Pre-Calculus, Science &amp; Engineering</li> <li>MATH 10A, 10B, 10C — Calculus</li> <li>MATH 20A, 20B, 20C — Calculus, Science &amp; Engineering</li> </ul> </td> </tr> <tr> <td> <h3>COMPUTER PROGRAMMING</h3> <ul> <li>CSE 5A — Introduction to Programming I</li> <li>CSE 8A, 8B ** — Intro. to Computer Science; Java</li> <li>CSE 11 ** — Intro. to Computer Science; Java</li> <li>ECE 15—Engineering Computation</li> <li>COGS 18 — Intro. to Programming for Cognitive Science</li> <li>MAE 9 — C/C++ Programming</li> </ul> <p><em>**&nbsp; Available only to CSE majors Fall quarter<br> #&nbsp; Prerequisite for the calculus sequence. Take only if you need calculus for your major.<br> &nbsp;</em></p> </td> </tr> </tbody> </table> </td> </tr> </tbody> </table>");
		Text area2 = new Text(" <table> <tbody> <tr><th> Approved Courses designed for Science/Engineering Majors and Pre-Medical Students </th></tr> <tr> <th>Course Number</th> <th>Course Title</th> <th>Prerequisite(s)</th> </tr> <tr> <td>BILD 1 (Biology)</td> <td>The Cell</td> <td>2 quarters of university-level chemistry</td> </tr> <tr> <td>BILD 2</td> <td>Multicellular Life</td> <td>2 quarters of university-level chemistry</td> </tr> <tr> <td>BILD 3</td> <td>Organic and Evolutionary Biology</td> <td>1 year of high school biology</td> </tr> <tr> <td>CHEM 4</td> <td>Basic Chemistry<br> (Should only be taken by students planning further study in Chemistry)</td> <td>MATH 3C or 4C</td> </tr> <tr> <td>CHEM 6A/AH</td> <td>General Chemistry</td> <td>High school chemistry or physics</td> </tr> <tr> <td>CHEM 6B/BH</td> <td>General Chemistry</td> <td>CHEM 6A &amp; concurrent enrollment in MATH 10B, 20B, or higher</td> </tr> <tr> <td>CHEM 6C/CH</td> <td>General Chemistry</td> <td>CHEM 6B (and MATH 20B for CHEM 6CH only)</td> </tr> <tr> <td>ECE 80</td> <td>Photonics of Everyday Life</td> <td>Simple concepts of calculus (see instructor)<br> or Math 10A or 20A</td> </tr> <tr> <td>PHYS 1A/AL<br> Must sign up for both</td> <td>Mechanics</td> <td>MATH 10A, concurrent enrollment in MATH 10B</td> </tr> <tr> <td>PHYS 1B/BL<br> Must sign up for both</td> <td>Electricity and Magnetism</td> <td>PHYS 1A, concurrent enrollment in MATH 10C (or MATH 10D or MATH 11)</td> </tr> <tr> <td>PHYS 1C/CL<br> Must sign up for both</td> <td>Waves, Optics and Modern Physics</td> <td>PHYS 1B, MATH 10C (or MATH 10D or MATH 11)</td> </tr> <tr> <td>PHYS 2A</td> <td>Mechanics</td> <td>MATH 20A, concurrent enrollment in MATH 20B</td> </tr> <tr> <td>PHYS 2B</td> <td>Electricity and Magnetism</td> <td>PHYS 2A, Math 20B, concurrent enrollment<br> in MATH 20C</td> </tr> <tr> <td>PHYS 2C</td> <td>Fluids, Waves, Thermodynamics, and Optics</td> <td>PHYS 2B, MATH 21C or 20C, concurrent enrollment<br> in MATH 20D</td> </tr> <tr> <td>PHYS 2D</td> <td>Relativity and Quantum Physics</td> <td>PHYS 2B, MATH 20D or 21D</td> </tr> <tr> <td>PHYS 4A-4E</td> <td>Physics for Physics Majors</td> </tr> </tbody> </table> <table> <tbody> <tr><th>Approved Courses designed for Non-Science Majors</th></tr> <tr> <th>Course Number</th> <th>Course Title</th> <th>Prerequisite(s)</th> </tr> <tr> <td>ANTH 2</td> <td>Human Origins</td> <td>None</td> </tr> <tr> <td>BILD 7</td> <td>The Beginning of Life</td> <td>None</td> </tr> <tr> <td>BILD 10</td> <td>Fund Concepts Modern Biology</td> <td>None</td> </tr> <tr> <td>BILD 12</td> <td>Neurobiology and Behavior</td> <td>BILD 1, 2, 3, 10, 24, 26, 30, 32 or equivalent</td> </tr> <tr> <td>BILD 14</td> <td>Introduction to Plant Biology</td> <td>None</td> </tr> <tr> <td>BILD 16</td> <td>History of Life</td> <td>None</td> </tr> <tr> <td>BILD 18</td> <td>Human Impact on the Environment</td> <td>None</td> </tr> <tr> <td>BILD 20</td> <td>Human Genetics in Modern Society</td> <td>None</td> </tr> <tr> <td>BILD 22</td> <td>Human Nutrition</td> <td>None</td> </tr> <tr> <td>BILD 24</td> <td>Biology of Human Reproduction</td> <td>None</td> </tr> <tr> <td>BILD 26</td> <td>Human Physiology</td> <td>BILD 10 or equivalent</td> </tr> <tr> <td>BILD 28</td> <td>Human Biology</td> <td>None</td> </tr> <tr> <td>BILD 30</td> <td>Biology of Plagues</td> <td>None</td> </tr> <tr> <td>BILD 32</td> <td>Biomedicine / Cancer</td> <td>None</td> </tr> <tr> <td>BILD 36</td> <td>AIDS Science and Society</td> <td>None</td> </tr> <tr> <td>BILD 38</td> <td>Dementia, Science and Society</td> <td>None</td> </tr> <tr> <td>CHEM 11</td> <td>The Periodic Table</td> <td>Cannot be taken after another Chemistry course</td> </tr> <tr> <td>CHEM 12</td> <td>Molecules and Reactions</td> <td>CHEM 11 or good knowledge of high school chemistry</td> </tr> <tr> <td>CHEM 13</td> <td>Chemistry of Life</td> <td>CHEM 12</td> </tr> <tr> <td>CHEM 15</td> <td>Chemistry of the Universe</td> <td>Cannot be taken after any other chemistry course</td> </tr> <tr> <td>COGS 11</td> <td>Introduction to Cognitive Science: Minds and Brains</td> <td>None</td> </tr> <tr> <td>COGS 17</td> <td>Neurobiology of Cognition</td> <td>None</td> </tr> <tr> <td> <p>ENVR 30</p> </td> <td>Environmental Issues: Natural Sciences</td> <td>None</td> </tr> <tr> <td>ESYS 10</td> <td>Introduction to Environmental Systems</td> <td>None</td> </tr> <tr> <td>SIO 1</td> <td>The Planets</td> <td>None</td> </tr> <tr> <td>SIO 10</td> <td>The Earth</td> <td>None</td> </tr> <tr> <td>SIO 12</td> <td>History of the Earth and Evolution</td> <td>None</td> </tr> <tr> <td>SIO 15</td> <td>Natural Disasters</td> <td>None</td> </tr> <tr> <td>SIO 16</td> <td>Geology of National Parks</td> <td>None</td> </tr> <tr> <td>SIO 20</td> <td>The Atmosphere</td> <td>None</td> </tr> <tr> <td>SIO 25</td> <td>Climate Change and Society</td> <td>None</td> </tr> <tr> <td>SIO 30</td> <td>The Oceans</td> <td>None</td> </tr> <tr> <td>SIO 35</td> <td>Water</td> <td>None</td> </tr> <tr> <td>SIO 40</td> <td>Life and Climate on Earth</td> <td>None</td> </tr> <tr> <td>SIO 45</td> <td>Volcanoes</td> <td>None</td> </tr> <tr> <td>SIO 50 (6 units)</td> <td>Intro to Earth &amp; Environmental Sciences</td> <td>None</td> </tr> <tr> <td>PHYS 5</td> <td>The Universe</td> <td>None. Cannot take PHYS 5 if taking PHYS 7</td> </tr> <tr> <td>PHYS 7</td> <td>Introductory Astronomy</td> <td>College algebra rec.&nbsp; Can’t take PHYS 7 if taking PHYS 5</td> </tr> <tr> <td>PHYS 8</td> <td>Physics of Everyday Life</td> <td>None</td> </tr> <tr> <td>PHYS 9</td> <td>The Solar System</td> <td>None</td> </tr> <tr> <td>PHYS 10</td> <td>Concepts in Physics</td> <td>College algebra</td> </tr> <tr> <td>PHYS 11</td> <td>Survey of Physics</td> <td>MATH 10A or 20A, concurrent enrollment in MATH 10B or 20B</td> </tr> <tr> <td>PHYS 12</td> <td>Energy and the Environment</td> <td>None</td> </tr> <tr> <td>PSYC 2</td> <td>General Psychology: Biological Foundations</td> <td>None</td> </tr> </tbody> </table>");
		Text miscText2 = new Text("Students are required to demonstrate basic conversational and reading proficiency in a modern foreign language, or advanced reading proficiency in a classical language. The requirement may be satisfied by: Completion of a fourth quarter of language course (or third semester or equivalent elsewhere). Classes may be taken for a letter grade or P/NP. Self-directed language study (Linguistics 19) may NOT be used to satisfy this requirement. Passing a standardized language proficiency exam in French, German, Italian, Russian or Spanish. Click for Exam Dates. Passing an individually arranged language proficiency exam in languages other than those listed above see: http://ling.ucsd.edu/language/proficiency-exam.html for a list of testers and instructions. Earning a qualifying AP or IB score. Earning a score of 700 or higher on SAT II Language exam. (Please see ERC Academic Advising for a waiver form) Attending high school taught in a language other than English outside the U.S. (Please see ERC Academic Advising for a waiver form)");
		Text miscText3 = new Text("This two course requirements may be taken for letter or P/NP grade. At least one course must be from Group A (non-western).");
		Text area3 = new Text("<table> <tbody> <tr> <th>Group A: Non-Western Fine Arts</th> <th>Group B: Other Fine Arts</th> </tr> <tr> <td> <p>Music: 13AM, 13AF, 13AS</p> <p>Visual Arts: 21A &amp; 21B</p> <p>Any other 4-unit course from the departments of Music, Theatre and Dance, or Visual Arts with non-Western content may be petitioned <strong>before</strong> taking the course.</p> </td> <td>Any other 4-unit course, including performance, studio, or theory, and upper-division courses from from the departments of Music, Theatre and Dance, or Visual Arts.</td> </tr> </tbody> </table>");
		Text miscText4 = new Text("Three 4-unit courses from ONE designated geographic region. At least two of the three must be upper division courses. One of the three may be taken P/NP; the other two must be taken for letter grades. Students entering as freshmen must complete three 4-unit courses from one region. At least two of the three courses must be upper division (numbered 100 or higher). Two of the three courses must be taken for letter grades; the other one may be taken Pass/No Pass. Transfer students must take two 4-unit upper-division courses from the same region, one of which may be taken Pass/No Pass. Regional Specialization course lists are available through the links below. Courses not on the approved lists must be petitioned before taking the class. You may choose courses from approved departmental offerings in the humanities, social sciences, and fine arts. A list of approved courses for each region is available below. Courses not on the list must be petitioned before taking the course.");
		Text miscText5 = new Text(" <p>At least one upper-division course <strong>(numbered 100-199)</strong> in your academic program must include a significant writing component in English.</p> <p><strong><a href='../../_files/UDW List 2013-2014.pdf'>Click to view approved UDW List (PDF)</a><a href='../../_files/academics/UDW List 2012-2013.pdf'><br> </a></strong></p> <p><em>If you believe you have met the requirement using a course that is not included on our approved list, submit course syllabus and graded paper using Option A or B below:</em></p> <p><br> <strong>OPTION A:</strong> Submit one original graded long paper (2500-word minimum, approximately 10 - 12 pages) written for any upper-division course within or outside of your major.<br> <br> <strong>OPTION B:</strong> Submit a portfolio of original papers written for one or more upper-division courses within or outside of your major. The portfolio must include one paper of 1500 words or more (approximately 5-6 pages), and a minimum total word count of 3000 for the entire porfolio (i.e., one 1500 word paper plus several shorter papers).&nbsp; The papers for the potfolio must be submitted together.<br> <br> For both options, the paper(s) must be written in English and have received a passing or C- grade.&nbsp; You must also have received a passing grade in the course for which the paper was written.&nbsp; The writing should demonstrate invention of a thesis, an original argument, and development of the argument with evidence and analysis.&nbsp; Papers need not include secondary sources.&nbsp; Papers may include description, provided a significant portion of the paper is devoted to an analysis of the description.&nbsp; Poetry, short stories, in-class exams, group projects, and laboratory reports are NOT acceptable to meet this requirement.&nbsp;</p> <p>To facilitate processing, please do a word count before submitting the paper/portfolio to the ERC Academic Advising Office.&nbsp; We return your paper(s) immediately. Photocopies are not necessary.</p> ");
		Entity college = new Entity("CollegeTable");
		datastore.put(college);

		Entity ERC = new Entity("College", college.getKey());
		datastore.put(ERC);
		
		ERC.setProperty("name", "ERC");
		Text ERCDesc = new Text("Eleanor Roosevelt College (ERC) is one of the six colleges located on the campus at the University of California, San Diego. The college was named after former American First Lady Eleanor Roosevelt, who was a humanitarian as well as a champion of international cooperation and a major member of the early United Nations.");
		ERC.setProperty("description",ERCDesc);

		for (int i = 0; i < ERCGE.length; i++) {
			Entity ERCGEReq = new Entity("GEReqCourse",ERC.getKey());
			ERCGEReq.setProperty("CourseID",ERCGE[i]);
			entities_to_write.add(ERCGEReq);
		}
		
		Entity ERC_misc_GEReq = new Entity("MiscGEReqCourse",ERC.getKey());
		ERC_misc_GEReq.setProperty("Misc Text 1", miscText1);
		ERC_misc_GEReq.setProperty("Area 1", area1);
		ERC_misc_GEReq.setProperty("Area 2", area2);
		ERC_misc_GEReq.setProperty("Misc Text 2", miscText2);
		ERC_misc_GEReq.setProperty("Misc Text 3", miscText3);
		ERC_misc_GEReq.setProperty("Area 3", area3);
		ERC_misc_GEReq.setProperty("Misc Text 4", miscText4);
		ERC_misc_GEReq.setProperty("Misc Text 5", miscText5);

		entities_to_write.add(ERC_misc_GEReq);
		datastore.put(entities_to_write);

	}

	public void insertWarrenInfo () {
	
	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

	String[] warrenGE = {"WCWP 10A","WCWP 10B"};
	ArrayList<Entity> entities_to_write = new ArrayList<Entity>();
	
	// Strings of table html for misc GEs
	Text miscText1 = new Text("Two courses in calculus, symbolic logic, computer programming and/or statistics from the following list. These courses may overlap with major, minor, or applicable Program of Concentration requirements.");
	Text area1 = new Text("<table> <tbody> <tr>Mathematics/Advanced Statistics</tr> <tr><td>COGS 3</td></tr> <tr><td>COGS 8</td></tr> <tr><td>COGS 14</td></tr> <tr><td>COGS 18</td></tr> <tr><td>COGS 25</td></tr> <tr><td>CSE 3</td></tr> <tr><td>CSE 5A</td></tr> <tr><td>LIGN 17</td></tr> <tr><td>MAE 5</td></tr> <tr><td>MAE 9</td></tr> <tr><td>MAE 10</td></tr> <tr><td>MATH 10A</td></tr> <tr><td>MATH 10B</td></tr> <tr><td>MATH 20A</td></tr> <tr><td>MATH 20B</td></tr> <tr><td>PHIL 10</td></tr> <tr><td>PHIL 12</td></tr> <tr><td>PSYC 60</td></tr> <tr><td>POLI 30</td></tr> <tr><td>SOCI 60</td></tr> </tbody> </table>");
	Text miscText2 = new Text("Ethics and Society: Two courses, Phil 27 or Poli 27 and Phil 28 or Poli 28, must be taken for a letter-grade at UCSD. These courses may not overlap with any other requirement and must be taken after WCWP 10A-B or WARR 11A-B. ");
	Text miscText3 = new Text("Programs of Concentration: Two Programs of Concentration (PofCs) are required. Each must contain six, 4-unit courses (total of 24 units), at least three of which must be upper-division (courses numbered 100-199). Lower-division courses in PofCs may overlap with lower-division major courses. NO overlap is allowed in the upper-division courses. For students entering fall 2009 and after, only one PofC may be chosen from EAP, Humanities, Science and Technology, or Perspectives of Social Science. PofCs must be non-contiguous to your major and to each other.");
	Text miscText4 = new Text("Area Studies: For Engineering majors, B.S. only, two Area Studies (AS) are required. Each must contain three, 4-unit courses (total of 12 units), at least two of which must be upper-division. For students entering before fall 2009, only one course must be upper-division. Area Studies must be non-contiguous to the major and to each other.");
	Text miscText5 = new Text("Minors: Academic minors are optional, however, a minor may be used in lieu of a Program of Concentration or Area Study if it is noncontiguous to the major and the other Program of Concentration or Area Study. There may be no overlap between major and minor coursework at the upper-division level. For specific requirements, see the minor department.");
	Entity college = new Entity("CollegeTable");
	datastore.put(college);

	Entity warren = new Entity("College", college.getKey());
	datastore.put(warren);
	
	warren.setProperty("name", "warren");
	Text warrenDesc = new Text("Warren College's motto is Toward a Life in Balance, and we are dedicated to cultivating responsible citizen scholars who will flourish during their careers at UC San Diego and beyond. The College strives to inculcate in each student an understanding of the important contributions an individual can make in society. This mission is supported by a number of critical components. Our core freshman sequence comprises Warren Writing and Ethics and Society . Our General Education requirements ensure that students will receive both breadth and depth in areas of study that complement the chosen major. Our co-curricular activities promote the development of the 'whole student.' Warren offers both resident and commuter students from all academic disciplines a wide array of engaging social, athletic, and cultural events and programs that will aid them in achieving that all-important balance.");
	warren.setProperty("description",warrenDesc);

	for (int i = 0; i < warrenGE.length; i++) {
		Entity warrenGEReq = new Entity("GEReqCourse",warren.getKey());
		warrenGEReq.setProperty("CourseID",warrenGE[i]);
		entities_to_write.add(warrenGEReq);
	}
	
	Entity warren_misc_GEReq = new Entity("MiscGEReqCourse",warren.getKey());
	warren_misc_GEReq.setProperty("Misc Text 1", miscText1);
	warren_misc_GEReq.setProperty("Area 1", area1);
	warren_misc_GEReq.setProperty("Misc Text 2", miscText2);
	warren_misc_GEReq.setProperty("Misc Text 3", miscText3);
	warren_misc_GEReq.setProperty("Misc Text 4", miscText4);
	warren_misc_GEReq.setProperty("Misc Text 5", miscText5);

	entities_to_write.add(warren_misc_GEReq);
	datastore.put(entities_to_write);

	}

	public void insertSixthInfo () {
	
	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

	String[] sixthGE = {"CAT 1","CAT 2","CAT 3"};
	ArrayList<Entity> entities_to_write = new ArrayList<Entity>();
	
	// Strings of table html for misc GEs
	Text miscText1 = new Text("Information Technology Fluency: Choose one of the approved computing courses from the Sixth College GE requirements list.");
	Text miscText2 = new Text("Breadth Requirements: Students must take 12 breadth courses encompassing a variety of disciplines. Social Analysis (2 social science courses) Narrative, Aesthetic, and Historical Reasoning (2 humanities courses) Analytical and Scientific Methods (2 science courses) Structured Reasoning (1 math/ logic course) Exploring Data (1 statistics course. This area can overlap with your major requirements) Societal Context (2 courses) Social Context Ethical Context (This area can overlap with your major requirements) Art Making (8 units)");
	Text miscText3 = new Text("Upper Division Requirements: Practicum course or project (This area can overlap with your major requirements) CAT 125 (Public Rhetoric and Practical Communication)");
	Text miscText4 = new Text("<a href='../../_files/GE_2013-2014_withBoxes.pdf' target='_blank'>Sixth College General Education (GE) requirements&nbsp;</a>");
	Entity college = new Entity("CollegeTable");
	datastore.put(college);

	Entity sixth = new Entity("College", college.getKey());
	datastore.put(sixth);
	
	sixth.setProperty("name", "sixth");
	Text sixthDesc = new Text("");
	sixth.setProperty("description",sixthDesc);

	for (int i = 0; i < sixthGE.length; i++) {
		Entity sixthGEReq = new Entity("GEReqCourse",sixth.getKey());
		sixthGEReq.setProperty("CourseID",sixthGE[i]);
		entities_to_write.add(sixthGEReq);
	}
	
	Entity sixth_misc_GEReq = new Entity("MiscGEReqCourse",sixth.getKey());
	sixth_misc_GEReq.setProperty("Misc Text 1", miscText1);
	sixth_misc_GEReq.setProperty("Misc Text 2", miscText2);
	sixth_misc_GEReq.setProperty("Misc Text 3", miscText3);
	sixth_misc_GEReq.setProperty("Misc Text 4", miscText4);

	entities_to_write.add(sixth_misc_GEReq);
	datastore.put(entities_to_write);

	}

}
