/**
 * Generated by Gas3 v3.1.0 (Granite Data Services).
 *
 * WARNING: DO NOT CHANGE THIS FILE. IT MAY BE OVERWRITTEN EACH TIME YOU USE
 * THE GENERATOR. INSTEAD, EDIT THE INHERITED CLASS (Person.as).
 */

package democustomer {

    import flash.events.EventDispatcher;
    import flash.net.FileReference;
    import flash.utils.IDataInput;
    import flash.utils.IDataOutput;
    import flash.utils.IExternalizable;
    import flash.utils.getQualifiedClassName;
    import mx.core.IUID;
    import mx.data.utils.Managed;
    import mx.utils.UIDUtil;
    import org.granite.collections.IPersistentCollection;
    import org.granite.meta;
    import org.granite.tide.IEntity;
    import org.granite.tide.IEntityManager;
    import org.granite.tide.IPropertyHolder;

    use namespace meta;

    [Managed]
    public class PersonBase implements IExternalizable, IUID {

        public function PersonBase() {
        }

        [Transient]
        meta var entityManager:IEntityManager = null;
		
        private var __initialized:Boolean = true;
        private var __detachedState:String = null;

        private var _accountExpired:Boolean;
        private var _accountLocked:Boolean;
        private var _company:Company;
        private var _enabled:Boolean;
        protected var _id:Number;
        private var _password:String;
        private var _passwordExpired:Boolean;
        private var _username:String;
        protected var _version:Number;

        meta function isInitialized(name:String = null):Boolean {
            if (!name)
                return __initialized;

            var property:* = this[name];
            return (
                (!(property is Person) || (property as Person).meta::isInitialized()) &&
                (!(property is IPersistentCollection) || (property as IPersistentCollection).isInitialized())
            );
        }

        meta function defineProxy(id:Number):void {
            __initialized = false;
            _id = id;
        }
        meta function defineProxy3(obj:* = null):Boolean {
            if (obj != null) {
                var src:PersonBase = PersonBase(obj);
                if (src.__detachedState == null)
                    return false;
                _id = src._id;
                __detachedState = src.__detachedState;
            }
            __initialized = false;
            return true;          
        }
        
        [Bindable(event="dirtyChange")]
		public function get meta_dirty():Boolean {
			return Managed.getProperty(this, "meta_dirty", false);
		}
    
    	public static const meta_constraints:Array = [
    		{ property: "username",
				blank: "BlankConstraint@1bcf2034false"
    		}, 
    		{ property: "password",
				blank: "BlankConstraint@3b4b442ffalse"
    		}, 
    		{ property: "accountExpired" }, 
    		{ property: "accountLocked" }, 
    		{ property: "company",
				association: "oneToOne"
    		}, 
    		{ property: "enabled" }, 
    		{ property: "passwordExpired" }
		]

        public function set accountExpired(value:Boolean):void {
            _accountExpired = value;
        }
        public function get accountExpired():Boolean {
            return _accountExpired;
        }

        public function set accountLocked(value:Boolean):void {
            _accountLocked = value;
        }
        public function get accountLocked():Boolean {
            return _accountLocked;
        }

        public function set company(value:Company):void {
            _company = value;
        }
        public function get company():Company {
            return _company;
        }

        public function set enabled(value:Boolean):void {
            _enabled = value;
        }
        public function get enabled():Boolean {
            return _enabled;
        }

        public function set id(value:Number):void {
            _id = value;
        }
        [Id]
        public function get id():Number {
            return _id;
        }

        public function set password(value:String):void {
            _password = value;
        }
        public function get password():String {
            return _password;
        }

        public function set passwordExpired(value:Boolean):void {
            _passwordExpired = value;
        }
        public function get passwordExpired():Boolean {
            return _passwordExpired;
        }

        public function set username(value:String):void {
            _username = value;
        }
        public function get username():String {
            return _username;
        }

        public function set version(value:Number):void {
            _version = value;
        }
        [Version]
        public function get version():Number {
            return _version;
        }

        public function set uid(value:String):void {
            // noop...
        }
        public function get uid():String {
            if (isNaN(_id))
                return UIDUtil.createUID();
            return getQualifiedClassName(this) + "#[" + String(_id) + "]";
        }

        meta function merge(em:IEntityManager, obj:*):void {
            var src:PersonBase = PersonBase(obj);
            __initialized = src.__initialized;
            __detachedState = src.__detachedState;
            if (meta::isInitialized()) {
               em.meta_mergeExternal(src._accountExpired, _accountExpired, null, this, 'accountExpired', function setter(o:*):void{_accountExpired = o as Boolean}, false);
               em.meta_mergeExternal(src._accountLocked, _accountLocked, null, this, 'accountLocked', function setter(o:*):void{_accountLocked = o as Boolean}, false);
               em.meta_mergeExternal(src._company, _company, null, this, 'company', function setter(o:*):void{_company = o as Company}, false);
               em.meta_mergeExternal(src._enabled, _enabled, null, this, 'enabled', function setter(o:*):void{_enabled = o as Boolean}, false);
               em.meta_mergeExternal(src._id, _id, null, this, 'id', function setter(o:*):void{_id = o as Number}, false);
               em.meta_mergeExternal(src._password, _password, null, this, 'password', function setter(o:*):void{_password = o as String}, false);
               em.meta_mergeExternal(src._passwordExpired, _passwordExpired, null, this, 'passwordExpired', function setter(o:*):void{_passwordExpired = o as Boolean}, false);
               em.meta_mergeExternal(src._username, _username, null, this, 'username', function setter(o:*):void{_username = o as String}, false);
               em.meta_mergeExternal(src._version, _version, null, this, 'version', function setter(o:*):void{_version = o as Number}, false);
            }
            else {
               em.meta_mergeExternal(src._id, _id, null, this, 'id', function setter(o:*):void{_id = o as Number});
            }
        }

        public function readExternal(input:IDataInput):void {
            __initialized = input.readObject() as Boolean;
            __detachedState = input.readObject() as String;
            if (meta::isInitialized()) {
                _accountExpired = input.readObject() as Boolean;
                _accountLocked = input.readObject() as Boolean;
                _company = input.readObject() as Company;
                _enabled = input.readObject() as Boolean;
                _id = function(o:*):Number { return (o is Number ? o as Number : Number.NaN) } (input.readObject());
                _password = input.readObject() as String;
                _passwordExpired = input.readObject() as Boolean;
                _username = input.readObject() as String;
                _version = function(o:*):Number { return (o is Number ? o as Number : Number.NaN) } (input.readObject());
            }
            else {
                _id = function(o:*):Number { return (o is Number ? o as Number : Number.NaN) } (input.readObject());
            }
        }

        public function writeExternal(output:IDataOutput):void {
            output.writeObject(__initialized);
            output.writeObject(__detachedState);
            if (meta::isInitialized()) { 
                output.writeObject((_accountExpired is IPropertyHolder) ? IPropertyHolder(_accountExpired).object : _accountExpired); 
                output.writeObject((_accountLocked is IPropertyHolder) ? IPropertyHolder(_accountLocked).object : _accountLocked); 
                output.writeObject((_company is IPropertyHolder) ? IPropertyHolder(_company).object : _company); 
                output.writeObject((_enabled is IPropertyHolder) ? IPropertyHolder(_enabled).object : _enabled); 
                output.writeObject((_id is IPropertyHolder) ? IPropertyHolder(_id).object : _id); 
                output.writeObject((_password is IPropertyHolder) ? IPropertyHolder(_password).object : _password); 
                output.writeObject((_passwordExpired is IPropertyHolder) ? IPropertyHolder(_passwordExpired).object : _passwordExpired); 
                output.writeObject((_username is IPropertyHolder) ? IPropertyHolder(_username).object : _username); 
                output.writeObject((_version is IPropertyHolder) ? IPropertyHolder(_version).object : _version);
            }
            else {
                output.writeObject(_id);
            }
        }
    }
}
